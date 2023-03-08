package com.roman.writes.tgtodoistbot.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Message

@Service
class TelegramService {

    val log: Logger = LoggerFactory.getLogger(TelegramService::class.java)

    fun update(message: Message) {
        log.info(message.toString())
    }
}

package com.roman.writes.tgtodoistbot.service

import com.roman.writes.tgtodoistbot.client.TelegramClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TelegramService(private val telegramClient: TelegramClient) {

    val log: Logger = LoggerFactory.getLogger(TelegramService::class.java)

    fun update(update: Update) {
        log.info(update.toString())
        telegramClient.sendHello(update)
    }
}

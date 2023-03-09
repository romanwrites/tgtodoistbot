package com.roman.writes.tgtodoistbot.client

import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TelegramClient(
    private val env: Environment,
) {

    fun sendHello(update: Update) {
        val restTemplate = RestTemplate()
        val telegramApiUrl = "https://api.telegram.org/bot"+ env.getProperty("TG_BOT_TOKEN") + "/sendMessage"
        val chatId = update.message.chat.id
        val text = "Hello"
        restTemplate.getForObject("$telegramApiUrl?chat_id=$chatId&text=$text", String::class.java)
    }
}
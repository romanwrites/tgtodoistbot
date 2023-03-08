package com.roman.writes.tgtodoistbot.controller;

import com.roman.writes.tgtodoistbot.service.TelegramService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Message

@RestController
class TelegramController(private val telegramService: TelegramService) {

    @PostMapping("/telegram/update")
    fun update(message: Message): ResponseEntity<String> {
        telegramService.update(message)
        return ResponseEntity.ok("OK");
    }
}

package com.roman.writes.tgtodoistbot.controller;

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Message

@RestController
class TelegramController {

    @PostMapping("/telegram/update")
    fun update(message: Message): ResponseEntity<String> {
        return ResponseEntity.ok("OK");
    }
}

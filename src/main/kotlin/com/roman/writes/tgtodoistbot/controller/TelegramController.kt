package com.roman.writes.tgtodoistbot.controller;

import com.roman.writes.tgtodoistbot.service.TelegramService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.telegram.telegrambots.meta.api.objects.Update

@RestController
class TelegramController(private val telegramService: TelegramService,
    ) {

    @PostMapping("/telegram/update")
    fun update(@RequestBody update: Update): ResponseEntity<String> {
        telegramService.update(update)

        return ResponseEntity.ok("Response sent")
    }
}

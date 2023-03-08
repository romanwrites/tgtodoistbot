package com.roman.writes.tgtodoistbot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.telegram.telegrambots.meta.api.objects.Message

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TelegramControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    val objectMapper: ObjectMapper = ObjectMapper().setPropertyNamingStrategy(
        PropertyNamingStrategies.SnakeCaseStrategy()
    )
    @Test
    fun `should return 200 OK when receiving a valid message`() {
        val request = """
        {
            "message_id": 1234,
            "date": 1622943874,
            "chat": {
                "id": 5678,
                "type": "private",
                "username": "johndoe"
            },
            "from": {
                "id": 4321,
                "first_name": "John",
                "last_name": "Doe",
                "username": "johndoe"
            },
            "text": "Hello, World!"
        }
        """.trimIndent()

        val message = objectMapper.readValue(request, Message::class.java)
        val response = restTemplate.postForEntity(
            "/telegram/update",
            message,
            String::class.java
        )
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }
}

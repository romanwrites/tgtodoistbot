package com.roman.writes.tgtodoistbot.controller

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PingControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert service is available`() {
        val response = restTemplate.getForEntity<String>("/ping")
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isEqualTo("OK")
    }
}

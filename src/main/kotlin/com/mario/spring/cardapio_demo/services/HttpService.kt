package com.mario.spring.cardapio_demo.services

import com.mario.spring.cardapio_demo.domains.food.Food
import com.mario.spring.cardapio_demo.utils.typeRef
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class HttpService(@Autowired private val restTemplate: RestTemplate) {

    val url = "http://localhost:8080/food"

    fun carregarDados(): List<Map<String, *>> {
        val request = RequestEntity<List<Map<String, *>>>(HttpMethod.GET, URI.create(url))
        val response = restTemplate.exchange(request, typeRef<List<Map<String, *>>>())

        if (response.statusCode == HttpStatus.OK) {
            response.body?.let { return it } ?: throw Exception("Corpo da requisição vazio")
        }

        throw Exception("Nenhuma comida encontrada")
    }
}
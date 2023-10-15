package com.mario.spring.cardapio_demo.services

import com.mario.spring.cardapio_demo.utils.typeRef
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
class HttpService(@Autowired @Qualifier("restTemplateCustom") private val restTemplate: RestTemplate) {

    val url = "http://localhost:8080/food"

    fun carregarDados(): List<Map<String, *>> {
//        val request = RequestEntity<List<Map<String, *>>>(HttpMethod.GET, URI.create(url))
//        val response = restTemplate.exchange(request, typeRef<List<Map<String, *>>>())

        val entity = restTemplate.getForEntity<List<Map<String, *>>>(
            url,
            typeRef<List<Map<String, *>>>()
        )

        if (entity.statusCode == HttpStatus.OK) {
            entity.body?.let { return it } ?: throw Exception("Corpo da requisição vazio")
        }

        throw Exception("Nenhuma comida encontrada")
    }
}
package com.mario.spring.cardapio_demo.infra

import com.samskivert.mustache.DefaultCollector
import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Mustache.TemplateLoader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


@Configuration
class CardapioConfiguration {
    @Bean
    fun mustacheCompiler(templateLoader: TemplateLoader?, environment: Environment?): Mustache.Compiler {
        return Mustache.compiler()
            .defaultValue("Some Default Value")
            .withLoader(templateLoader)
            .withCollector(DefaultCollector())
    }

    @Bean("restTemplateCustom")
    fun restTemplate(): RestTemplate {
        val template = RestTemplate()
        val requestFactory = HttpComponentsClientHttpRequestFactory()
        requestFactory.setConnectTimeout(5000)
        requestFactory.setReadTimeout(5000)
        template.requestFactory = requestFactory
        return template
    }
}
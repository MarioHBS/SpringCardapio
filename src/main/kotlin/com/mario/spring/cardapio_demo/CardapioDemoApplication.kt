package com.mario.spring.cardapio_demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.core.env.StandardEnvironment
import org.springframework.stereotype.Component

@SpringBootApplication
class CardapioDemoApplication

fun main(args: Array<String>) {
	val applicationBuilder = SpringApplicationBuilder(CardapioDemoApplication::class.java)
		.environment(object : StandardEnvironment() {
			override fun getSystemEnvironment(): Map<String, Any> {
				return HashMap()
			}

			override fun getSystemProperties(): Map<String, Any> {
				return HashMap()
			}
		})
	applicationBuilder.run(*args)
}

@Component
class Runner : ApplicationRunner {
	@Value("\${hello:Hello from code}")
	var hello: String? = null

	@Value("\${spring.datasource.url}")
	var banco: String? = null

	@Value("\${spring.datasource.username}")
	var user: String? = null
	@Throws(Exception::class)
	override fun run(args: ApplicationArguments) {
		println("Propriedade hello: $hello")
		println("Caminho do BD: $banco")
		println("Usuário do BD: $user")
	}
}

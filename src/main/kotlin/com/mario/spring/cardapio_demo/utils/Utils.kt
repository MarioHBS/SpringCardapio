package com.mario.spring.cardapio_demo.utils

import org.springframework.core.ParameterizedTypeReference

inline fun <reified T : Any> typeRef():
        ParameterizedTypeReference<T> = object : ParameterizedTypeReference<T>() {}
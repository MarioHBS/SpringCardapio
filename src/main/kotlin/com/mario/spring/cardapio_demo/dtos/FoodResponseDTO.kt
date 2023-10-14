package com.mario.spring.cardapio_demo.dtos

data class FoodResponseDTO(
    val id: Long = 0,
    var title: String,
    var image: String,
    var price: Int
)

data class FoodRequestDTO(
    var title: String = "",
    var image: String = "",
    var price: Int = -1
)
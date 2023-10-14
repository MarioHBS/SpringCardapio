package com.mario.spring.cardapio_demo.dtos

data class FoodResponseDTO(
    val id: Long = 0,
    override var title: String = "",
    override var image: String = "",
    override var price: String = "0",
    ) : FoodRequestDTO(title, image, price)

open class FoodRequestDTO(
    open val title: String,
    open val image: String,
    open val price: String
)
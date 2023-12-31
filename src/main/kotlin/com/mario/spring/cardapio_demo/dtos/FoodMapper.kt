package com.mario.spring.cardapio_demo.dtos

import com.mario.spring.cardapio_demo.domains.food.Food

object FoodMapper {
    fun toDto(food: Food): FoodResponseDTO =
        FoodResponseDTO(title = food.title, image = food.image, price = food.price.toString(), id = food.id)

    fun toFood(dto: FoodRequestDTO): Food = Food(dto.title, dto.image, dto.price.toInt())

    fun fromMap(map: Map<String, *>) =
        Food(
            id = map["id"]!!.toString().toLong(),
            title = map["title"]!!.toString(),
            image = map["image"]!!.toString(),
            price = map["price"]!!.toString().toInt()
        )

}

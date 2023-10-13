package com.mario.spring.cardapio_demo.services

import com.mario.spring.cardapio_demo.domains.food.Food
import com.mario.spring.cardapio_demo.repositories.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FoodService @Autowired constructor(private val repository: FoodRepository) {
    fun findAllFood(): MutableList<Food> = repository.findAll()
    fun saveFood(food: Food) = repository.save(food) // TODO: fazer tratamento de requisições
}
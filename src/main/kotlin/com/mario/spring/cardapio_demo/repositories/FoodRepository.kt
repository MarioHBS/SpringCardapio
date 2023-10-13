package com.mario.spring.cardapio_demo.repositories

import com.mario.spring.cardapio_demo.domains.food.Food
import org.springframework.data.jpa.repository.JpaRepository

interface FoodRepository : JpaRepository<Food, Long> {
}
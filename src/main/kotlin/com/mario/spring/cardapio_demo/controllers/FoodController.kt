package com.mario.spring.cardapio_demo.controllers

import com.mario.spring.cardapio_demo.dtos.FoodResponseDTO
import com.mario.spring.cardapio_demo.dtos.FoodMapper
import com.mario.spring.cardapio_demo.dtos.FoodRequestDTO
import com.mario.spring.cardapio_demo.services.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("food")
class FoodController {
    @Autowired
    lateinit var foodService: FoodService

    @CrossOrigin(origins = ["http://localhost:8080"], allowedHeaders = ["*"])
    @GetMapping
    fun getAll(): List<FoodResponseDTO> {
        return foodService.findAllFood().stream().map(FoodMapper::toDto).toList()
    }

//    @ResponseBody
    @PostMapping
    fun createFood(@RequestBody foodDto: FoodRequestDTO) {
        val food = FoodMapper.toFood(foodDto)
        foodService.saveFood(food)
    }
}
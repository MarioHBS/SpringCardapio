package com.mario.spring.cardapio_demo.controllers

import com.mario.spring.cardapio_demo.dtos.FoodResponseDTO
import com.mario.spring.cardapio_demo.dtos.FoodMapper
import com.mario.spring.cardapio_demo.dtos.FoodRequestDTO
import com.mario.spring.cardapio_demo.services.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
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

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @GetMapping
    fun getAll(): List<FoodResponseDTO> {
        return foodService.findAllFood().stream().map(FoodMapper::toDto).toList()
    }

//    @ResponseBody
    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @PostMapping
    fun createFood(@Validated foodDto: FoodRequestDTO): String {
        val food = FoodMapper.toFood(foodDto)
        foodService.saveFood(food)
        return "redirect:/food"
    } // @RequestBody
}
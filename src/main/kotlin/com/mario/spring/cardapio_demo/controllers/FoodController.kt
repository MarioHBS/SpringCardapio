package com.mario.spring.cardapio_demo.controllers

import com.mario.spring.cardapio_demo.domains.food.Food
import com.mario.spring.cardapio_demo.dtos.FoodResponseDTO
import com.mario.spring.cardapio_demo.dtos.FoodMapper
import com.mario.spring.cardapio_demo.dtos.FoodRequestDTO
import com.mario.spring.cardapio_demo.services.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("food")
class FoodController {
    @Autowired
    lateinit var foodService: FoodService

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @GetMapping
    fun getAll(): ResponseEntity<List<FoodResponseDTO>> {
        return ResponseEntity.ok(foodService.findAllFood().stream().map(FoodMapper::toDto).toList())
    }

//    @ResponseBody
    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @PostMapping
    fun createFood(@RequestBody foodDto: FoodRequestDTO): ResponseEntity<String> {
        val food = FoodMapper.toFood(foodDto)

        return ResponseEntity.ok().body("${food.title} registrada com sucesso")
    } // @RequestBody
}
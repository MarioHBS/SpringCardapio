package com.mario.spring.cardapio_demo.controllers

import com.mario.spring.cardapio_demo.dtos.FoodMapper
import com.mario.spring.cardapio_demo.dtos.FoodRequestDTO
import com.mario.spring.cardapio_demo.dtos.FoodResponseDTO
import com.mario.spring.cardapio_demo.services.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun getAll(): ResponseEntity<List<FoodResponseDTO>> {
        val allFood = foodService.findAllFood()
        //println("Todas: $allFood")
        return ResponseEntity.ok(allFood.stream().map(FoodMapper::toDto).toList())
    }

    //    @ResponseBody
    @PostMapping
    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    fun createFood(@RequestBody @Validated foodDto: FoodRequestDTO): ResponseEntity<Map<String, *>> {
        val food = FoodMapper.toFood(foodDto)
        return if (foodService.saveFood(food).title == foodDto.title)
            ResponseEntity.ok().body(
                mapOf(
                    "status" to HttpStatus.OK.reasonPhrase,
                    "title" to food.title,
                    "message" to "Registered successfully"
                )
            )
        else
            ResponseEntity.notFound().build()
    } // @RequestBody
}
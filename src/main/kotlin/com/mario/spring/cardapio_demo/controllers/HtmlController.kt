package com.mario.spring.cardapio_demo.controllers

import com.mario.spring.cardapio_demo.dtos.FoodMapper
import com.mario.spring.cardapio_demo.dtos.FoodRequestDTO
import com.mario.spring.cardapio_demo.dtos.FoodResponseDTO
import com.mario.spring.cardapio_demo.services.FoodService
import com.mario.spring.cardapio_demo.services.HttpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HtmlController @Autowired constructor(
    private val service: HttpService,
    private val foodService: FoodService
) {
    @GetMapping("/")
    fun openPage(model: Model): String {
        val listOfFoods = service.carregarDados().stream().map(FoodMapper::fromMap).toList()
        model["title"] = "Cardápio" // addAttribute("title", "Blog")
        model["foods"] = listOfFoods
        return "cardapio"
    }

    /*@PostMapping("/save")
    fun saveFood(@Validated request: FoodRequestDTO): String {
        foodService.saveFood(FoodMapper.toFood(request))
        return "redirect:/"
    }*/
}
package com.mario.spring.cardapio_demo.domains.food

import jakarta.persistence.*

@Entity
@Table(name = "foods")
class Food(
    var title: String,
    var image: String,
    var price: Int,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0L
)
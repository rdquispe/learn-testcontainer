package com.rodrigo.quispe.learntestcontainer.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HiController {

    @GetMapping("/hi")
    fun hi(): Any {
        return hashMapOf("message" to "hi")
    }
}
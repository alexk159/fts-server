package com.akiryushkin.ftsserver.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class MainController {
    @GetMapping("/test")
    fun test(): String {
        return "Hello"
    }
}
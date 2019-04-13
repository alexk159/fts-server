package com.akiryushkin.ftsserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FtsServerApplication

fun main(args: Array<String>) {
    runApplication<FtsServerApplication>(*args)
}

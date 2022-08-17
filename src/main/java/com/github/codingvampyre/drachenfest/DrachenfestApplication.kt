package com.github.codingvampyre.drachenfest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DrachenfestApplication

fun main(args: Array<String>) {
    runApplication<DrachenfestApplication>(*args)
}

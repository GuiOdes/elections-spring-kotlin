package com.kotlin.elections

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElectionsApplication

fun main(args: Array<String>) {
	runApplication<ElectionsApplication>(*args)
}

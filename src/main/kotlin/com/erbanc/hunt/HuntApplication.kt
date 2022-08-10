package com.erbanc.hunt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HuntApplication

fun main(args: Array<String>) {
	runApplication<HuntApplication>(*args)
}

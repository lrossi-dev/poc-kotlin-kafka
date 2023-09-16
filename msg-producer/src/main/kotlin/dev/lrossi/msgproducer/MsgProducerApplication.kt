package dev.lrossi.msgproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsgProducerApplication

fun main(args: Array<String>) {
	runApplication<MsgProducerApplication>(*args)
}

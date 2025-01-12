package io.cheonkyu

import io.cheonkyu.producer.EventTopicProducer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)
}

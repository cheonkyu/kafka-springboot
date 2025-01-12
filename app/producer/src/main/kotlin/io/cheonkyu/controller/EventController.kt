package io.cheonkyu.controller

import io.cheonkyu.producer.EventTopicProducer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event")
class EventController(val eventTopicProducer: EventTopicProducer) {
    @GetMapping("/")
    fun test() {
        eventTopicProducer.runner1();
    }
}
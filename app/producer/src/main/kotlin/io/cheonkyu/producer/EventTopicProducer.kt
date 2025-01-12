package io.cheonkyu.producer

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class EventTopicProducer(
    val template: KafkaTemplate<String, String>
) {

    @Bean
    fun runner1(): ApplicationRunner {
        return ApplicationRunner { template.send("foobar", "test") }
    }

    @Bean
    fun runner2(): ApplicationRunner {
        return ApplicationRunner { template.send("foobar", "failMessage") }
    }
}
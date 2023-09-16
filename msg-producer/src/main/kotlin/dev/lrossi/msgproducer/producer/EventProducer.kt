package dev.lrossi.msgproducer.producer

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

@Component
class EventProducer(val kafkaTemplate: KafkaTemplate<String, String>) {

    @Value("\${spring.kafka.topic-name}")
    lateinit var topicName: String

    fun sendEvent(message: String) {
        logger.info { "Sending message to topic $topicName" }
        kafkaTemplate.send(topicName, message)
    }
}
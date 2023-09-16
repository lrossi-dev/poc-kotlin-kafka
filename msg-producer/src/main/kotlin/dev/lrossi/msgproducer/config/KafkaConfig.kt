package dev.lrossi.msgproducer.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {

    @Value("\${spring.kafka.topic-name}")
    lateinit var topicName: String

    @Bean
    fun topicCreate(): NewTopic {
        return TopicBuilder.name(topicName).build()
    }
}
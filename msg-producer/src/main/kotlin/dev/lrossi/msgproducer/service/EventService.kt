package dev.lrossi.msgproducer.service

import dev.lrossi.msgproducer.dto.EventDTO
import dev.lrossi.msgproducer.producer.EventProducer
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

private val logger = KotlinLogging.logger { }

@Service
class EventService {

    @Autowired
    lateinit var eventProducer: EventProducer

    fun sendEvent(event: EventDTO) {
        try {
            logger.info { "Sanitizing message..." }
            eventProducer.sendEvent(event.message)
            logger.info { "Message sent" }
        } catch (ex: RuntimeException) {
            logger.error("Error while sending event. ex=${ex.message}", ex)
            throw ex;
        }
    }
}
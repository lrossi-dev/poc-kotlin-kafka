package dev.lrossi.msgproducer.controller

import dev.lrossi.msgproducer.dto.EventDTO
import dev.lrossi.msgproducer.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event")
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @PostMapping(
            "/create",
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun createEvent(@RequestBody event: EventDTO): ResponseEntity<Void> {
        return try {
            eventService.sendEvent(event)
            ResponseEntity.ok().build()
        } catch (ex: RuntimeException) {
            ResponseEntity.internalServerError().build() // This is really ugly but will do for now
        }
    }
}
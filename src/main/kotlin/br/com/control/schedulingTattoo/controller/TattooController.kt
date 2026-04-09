package br.com.control.schedulingTattoo.controller

import br.com.control.schedulingTattoo.dto.ScheduleDateForm
import br.com.control.schedulingTattoo.dto.TattooView
import br.com.control.schedulingTattoo.service.TattooService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/tattoos")
class TattooController(private val service: TattooService) {

    @GetMapping
    fun listAll(): ResponseEntity<List<TattooView>> {
        return ResponseEntity.ok(service.listAll())
    }

    @PostMapping("/schedule")
    @Transactional
    fun scheduleDate(@RequestBody @Valid form: ScheduleDateForm): ResponseEntity<TattooView> {
        val tattooView = service.scheduleDate(form)
        return ResponseEntity.ok(tattooView)
    }
}


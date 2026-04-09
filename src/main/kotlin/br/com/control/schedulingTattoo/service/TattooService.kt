package br.com.control.schedulingTattoo.service

import br.com.control.schedulingTattoo.dto.ScheduleDateForm
import br.com.control.schedulingTattoo.dto.TattooView
import br.com.control.schedulingTattoo.repository.TattooRepository
import org.springframework.stereotype.Service

@Service
class TattooService(private val repository: TattooRepository) {

    fun listAll(): List<TattooView> {
        return repository.findAll().map { tattoo ->
            TattooView(
                id = tattoo.id,
                name = tattoo.name,
                image = tattoo.image,
                scheduledDates = tattoo.scheduledDates
            )
        }
    }

    fun scheduleDate(form: ScheduleDateForm): TattooView {
        val tattoo = repository.findById(form.id)
            .orElseThrow { NoSuchElementException("Tattoo com id ${form.id} não encontrado") }

        tattoo.scheduledDates.add(form.date)
        repository.save(tattoo)

        return TattooView(
            id = tattoo.id,
            name = tattoo.name,
            image = tattoo.image,
            scheduledDates = tattoo.scheduledDates
        )
    }
}


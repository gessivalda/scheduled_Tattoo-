package br.com.control.schedulingTattoo.service

import br.com.control.schedulingTattoo.dto.ScheduleDateForm
import br.com.control.schedulingTattoo.dto.ScheduleView
import br.com.control.schedulingTattoo.dto.TattooView
import br.com.control.schedulingTattoo.model.Schedule
import br.com.control.schedulingTattoo.model.Tattoo
import br.com.control.schedulingTattoo.repository.TattooRepository
import org.springframework.stereotype.Service

@Service
class TattooService(private val repository: TattooRepository) {

    fun listAll(): List<TattooView> {
        return repository.findAll().map { it.toView() }
    }

    fun scheduleDate(form: ScheduleDateForm): TattooView {
        val tattoo = repository.findById(form.id)
            .orElseThrow { NoSuchElementException("Tattoo com id ${form.id} não encontrado") }

        tattoo.schedules.add(Schedule(scheduledDate = form.date, clientName = form.clientName))
        repository.save(tattoo)

        return tattoo.toView()
    }

    private fun Tattoo.toView() = TattooView(
        id = id,
        name = name,
        image = image,
        schedules = schedules.map { ScheduleView(date = it.scheduledDate, clientName = it.clientName) }
    )
}

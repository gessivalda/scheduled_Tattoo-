package br.com.control.schedulingTattoo.dto

data class TattooView(
    val id: Int?,
    val name: String,
    val image: String,
    val schedules: List<ScheduleView>
)

data class ScheduleView(
    val date: String,
    val clientName: String
)

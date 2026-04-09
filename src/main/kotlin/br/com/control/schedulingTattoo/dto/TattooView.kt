package br.com.control.schedulingTattoo.dto

data class TattooView(
    val id: Int?,
    val name: String,
    val image: String,
    val scheduledDates: List<String>
)


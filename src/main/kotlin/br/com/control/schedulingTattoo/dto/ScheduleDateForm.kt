package br.com.control.schedulingTattoo.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern

data class ScheduleDateForm(
    @field:NotNull
    val id: Int,
    @field:Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data deve estar no formato YYYY-MM-DD")
    val date: String
)


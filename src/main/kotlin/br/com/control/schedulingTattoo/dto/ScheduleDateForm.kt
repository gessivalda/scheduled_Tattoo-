package br.com.control.schedulingTattoo.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class ScheduleDateForm(
    @field:NotNull
    val id: Int,
    @field:Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data deve estar no formato YYYY-MM-DD")
    val date: String,
    @field:NotBlank
    @field:Size(min = 2, max = 150)
    val clientName: String
)

package br.com.control.schedulingTattoo.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Schedule(
    @Column(name = "scheduled_date", nullable = false)
    var scheduledDate: String,
    @Column(name = "client_name", nullable = false)
    var clientName: String
)

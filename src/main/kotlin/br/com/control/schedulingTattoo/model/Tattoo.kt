package br.com.control.schedulingTattoo.model

import jakarta.persistence.*

@Entity
data class Tattoo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String,
    var image: String,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tattoo_scheduled_dates", joinColumns = [JoinColumn(name = "tattoo_id")])
    @Column(name = "scheduled_date")
    var scheduledDates: MutableList<String> = mutableListOf()
)


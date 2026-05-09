package br.com.control.schedulingTattoo.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column(unique = true, nullable = false)
    var email: String,
    @Column(name = "password_hash", nullable = false)
    var passwordHash: String
)

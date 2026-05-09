package br.com.control.schedulingTattoo.repository

import br.com.control.schedulingTattoo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Int> {
    fun findByEmail(email: String): Optional<User>
}

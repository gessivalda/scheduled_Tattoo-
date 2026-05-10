package br.com.control.schedulingTattoo.config

import br.com.control.schedulingTattoo.model.User
import br.com.control.schedulingTattoo.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class DataSeeder(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val email = "admin@tattoo.com"
        if (userRepository.findByEmail(email).isEmpty) {
            userRepository.save(
                User(email = email, passwordHash = passwordEncoder.encode("password"))
            )
            println(">>> Admin criado: $email / password")
        }
    }
}

package br.com.control.schedulingTattoo.service

import br.com.control.schedulingTattoo.dto.LoginForm
import br.com.control.schedulingTattoo.dto.LoginResponse
import br.com.control.schedulingTattoo.repository.UserRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {
    fun login(form: LoginForm): LoginResponse {
        val user = userRepository.findByEmail(form.email)
            .orElseThrow { BadCredentialsException("Credenciais inválidas") }

        if (!passwordEncoder.matches(form.password, user.passwordHash)) {
            throw BadCredentialsException("Credenciais inválidas")
        }

        val token = jwtService.generateToken(user.email)
        return LoginResponse(token = token, expiresIn = jwtService.expirationSeconds)
    }
}

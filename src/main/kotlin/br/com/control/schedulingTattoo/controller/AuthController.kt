package br.com.control.schedulingTattoo.controller

import br.com.control.schedulingTattoo.dto.LoginForm
import br.com.control.schedulingTattoo.dto.LoginResponse
import br.com.control.schedulingTattoo.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/login")
    fun login(@RequestBody @Valid form: LoginForm): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok(authService.login(form))
    }

    @ExceptionHandler(BadCredentialsException::class)
    fun handleBadCredentials(ex: BadCredentialsException): ResponseEntity<Map<String, String>> {
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(mapOf("message" to "Credenciais inválidas"))
    }
}

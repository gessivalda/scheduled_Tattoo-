package br.com.control.schedulingTattoo.repository

import br.com.control.schedulingTattoo.model.Tattoo
import org.springframework.data.jpa.repository.JpaRepository

interface TattooRepository : JpaRepository<Tattoo, Int>


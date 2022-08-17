package com.github.codingvampyre.drachenfest.repositories

import com.github.codingvampyre.drachenfest.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface ParticipantRepository : JpaRepository<Account, Long> {
	fun findByemail(email: String): Account?
}
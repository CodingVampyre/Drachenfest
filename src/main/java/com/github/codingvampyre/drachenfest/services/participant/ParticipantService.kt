package com.github.codingvampyre.drachenfest.services.participant

import com.github.codingvampyre.drachenfest.domain.Account
import com.github.codingvampyre.drachenfest.domain.Role
import com.github.codingvampyre.drachenfest.dtos.ParticipantCreateRequestDto
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository
import com.github.codingvampyre.drachenfest.services.password.PasswordService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ParticipantService(private val participantRepository: ParticipantRepository, private val passwordService: PasswordService) {
	fun findAll(): List<Account> {
		return participantRepository.findAll()
	}

	fun findByemail(email: String): Account? {
		return participantRepository.findByemail(email)
	}

	fun create(participantCreateRequestDto: ParticipantCreateRequestDto): Account {
		// check if such a participant already exists
		val p = participantRepository.findByemail(participantCreateRequestDto.email)
		if (p != null) throw ResponseStatusException(HttpStatus.BAD_REQUEST)

		// hash password
		val password = participantCreateRequestDto.password
		val passwordHash = passwordService.hash(password)

		val newAcc = Account(
				uuid = UUID.randomUUID(),
				email = participantCreateRequestDto.email,
				password = passwordHash,
				role = Role.Participant
		)

		// apply
		return participantRepository.save(newAcc)
	}
}
package com.github.codingvampyre.drachenfest.controllers

import com.github.codingvampyre.drachenfest.domain.Account
import com.github.codingvampyre.drachenfest.dtos.ParticipantCreateRequestDto
import com.github.codingvampyre.drachenfest.services.participant.ParticipantService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class AccountController internal constructor(private val participantService: ParticipantService) {
	@GetMapping("/participants")
	fun list(): List<Account> {
		return participantService.findAll()
	}

	@GetMapping("/participants/{email}")
	fun describeByUuid(@PathVariable email: String): Account? {
		return participantService.findByemail(email)
	}

	@PostMapping("/participants")
	fun create(@RequestBody participantCreateRequestDto: @Valid ParticipantCreateRequestDto): Account {
		return participantService.create(participantCreateRequestDto)
	}
}
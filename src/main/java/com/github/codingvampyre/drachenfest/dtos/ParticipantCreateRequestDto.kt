package com.github.codingvampyre.drachenfest.dtos

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class ParticipantCreateRequestDto (
		@field:NotEmpty
		@field:Email
        val email: String,

		@field:NotEmpty
		@field:Size(min = 8)
        val password: String,
)

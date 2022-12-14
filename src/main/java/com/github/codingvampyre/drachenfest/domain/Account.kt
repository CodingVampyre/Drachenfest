package com.github.codingvampyre.drachenfest.domain

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
open class Account(
		@Column(nullable = false)
		open var password: String? = null,

		@Column(unique = true, nullable = false)
		open var email: String? = null,

		@Column(unique = true)
		open var uuid: @NotNull UUID? = null,

		@Enumerated(EnumType.STRING)
		open var role: @NotNull Role? = Role.Participant,

		@OneToMany(mappedBy = "account")
		open var tickets: MutableList<Ticket> = mutableListOf(),

		@OneToMany(mappedBy = "account")
		open var purchases: MutableList<Purchase> = mutableListOf(),
): BaseEntity()

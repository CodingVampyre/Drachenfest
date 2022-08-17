package com.github.codingvampyre.drachenfest.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
open class Event(
		@Column(nullable = false)
		open var name: String? = null,

		@Column(nullable = false)
		open var uuid: UUID? = null,

		@Column(nullable = false)
		open var beginAt: Date? = null,

		@Column(nullable = false)
		open var endAt: Date? = null,

		@OneToMany(mappedBy = "event")
		open var ticketTypes: MutableList<TicketType> = mutableListOf(),
) : BaseEntity()

package com.github.codingvampyre.drachenfest.domain

import javax.persistence.*
import javax.validation.constraints.Positive

@Entity
class TicketType : BaseEntity() {

	@Column(nullable = false)
	private val name: String? = null

	@Column(nullable = false)
	@Positive
	private val price: Float? = null

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private val event: Event? = null

	@OneToMany(mappedBy = "ticketType")
	private val tickets: MutableList<Ticket> = mutableListOf()
}
package com.github.codingvampyre.drachenfest.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Ticket : BaseEntity() {
	@Column(nullable = false)
	private val barcode: @NotNull String? = null

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private val event: Event? = null

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_type_id")
	private val ticketType: TicketType? = null

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private val account: Account? = null

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "purchase_id")
	private val purchase: Purchase? = null
}
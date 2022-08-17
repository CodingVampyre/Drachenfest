package com.github.codingvampyre.drachenfest.domain

import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
class Purchase : BaseEntity() {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private val account: Account? = null

	@OneToMany(mappedBy = "purchase")
	private val tickets: List<Ticket>? = null

	@Column(nullable = true)
	private val price: Float? = null

	@ColumnDefault("false")
	private val isPaid = false
}
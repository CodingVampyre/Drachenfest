package com.github.codingvampyre.drachenfest.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity : Serializable {
	@GeneratedValue
	@Id
	private val Id: Long? = null

	@CreationTimestamp
	private val createdAt: Date? = null

	@UpdateTimestamp
	private val updatedAt: Date? = null
	override fun equals(o: Any?): Boolean {
		if (this === o) return true
		if (o == null || javaClass != o.javaClass) return false
		val that = o as BaseEntity
		return Id == that.Id
	}

	override fun hashCode(): Int {
		return Id?.hashCode() ?: 0
	}
}
package com.gmartinez.tulshoppingcart.model

import org.springframework.data.domain.Persistable
import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.PostLoad
import javax.persistence.PostPersist

@MappedSuperclass
abstract class AssignedIdBaseEntity(givenId: UUID? = null) : Persistable<UUID> {
    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private val id: UUID = givenId ?: UUID.randomUUID()

    @Transient
    private var persisted: Boolean = givenId != null

    override fun getId(): UUID = id

    override fun isNew(): Boolean = !persisted

    override fun hashCode(): Int = id.hashCode()

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other == null -> false
            other !is AssignedIdBaseEntity -> false
            else -> getId() == other.getId()
        }
    }

    @PostPersist
    @PostLoad
    private fun setPersisted() {
        persisted = true
    }

}

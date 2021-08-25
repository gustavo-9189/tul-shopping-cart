package com.gmartinez.tulshoppingcart.model

import java.util.*
import javax.persistence.Entity
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Product(
    @field:NotBlank(message = "El campo name es requerido")
    val name: String,
    @field:NotBlank(message = "El campo sku es requerido")
    val sku: String,
    @field:NotBlank(message = "El campo description es requerido")
    val description: String,
    @field:NotNull(message = "El campo price es requerido")
    val price: Double,
    @field:NotNull(message = "El campo amount es requerido")
    var amount: Int,
    @field:NotNull(message = "El campo withDiscount es requerido")
    val withDiscount: Boolean,
    id: UUID? = null
) : AssignedIdBaseEntity(id)

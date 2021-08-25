package com.gmartinez.tulshoppingcart.model

import com.gmartinez.tulshoppingcart.model.State.PENDING
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class ShoppingCart(
    @OneToMany var products: MutableList<Product>,
    var state: State = PENDING,
    id: UUID? = null
) : AssignedIdBaseEntity(id)

package com.gmartinez.tulshoppingcart.request

import com.gmartinez.tulshoppingcart.model.Product
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class ShoppingCartRequest(
    val idShoppingCart: UUID?,
    @field:Valid @field:NotNull val product: Product)
package com.gmartinez.tulshoppingcart.request

import com.gmartinez.tulshoppingcart.model.Product
import java.util.*

data class ShoppingCartRequest(val idShoppingCart: UUID?, val product: Product)
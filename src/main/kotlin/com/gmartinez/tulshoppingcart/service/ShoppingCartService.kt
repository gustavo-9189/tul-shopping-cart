package com.gmartinez.tulshoppingcart.service

import com.gmartinez.tulshoppingcart.model.Product
import com.gmartinez.tulshoppingcart.model.ShoppingCart
import com.gmartinez.tulshoppingcart.request.ShoppingCartRequest
import com.gmartinez.tulshoppingcart.response.CheckoutResponse
import java.util.*

interface ShoppingCartService {

    fun getProductsByCart(id: UUID): MutableList<Product>

    fun addProductToCart(shoppingCartRequest: ShoppingCartRequest): ShoppingCart

    fun updateProductToCart(id: UUID, product: Product): ShoppingCart

    fun deleteProductToCart(id: UUID, idProduct: UUID): ShoppingCart

    fun checkout(id: UUID): CheckoutResponse

}

package com.gmartinez.tulshoppingcart.service

import com.gmartinez.tulshoppingcart.model.Product
import com.gmartinez.tulshoppingcart.model.ShoppingCart
import com.gmartinez.tulshoppingcart.model.State
import com.gmartinez.tulshoppingcart.repository.ShoppingCartRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

internal class ShoppingCartServiceImplTest {

    private val repository: ShoppingCartRepository = Mockito.mock(ShoppingCartRepository::class.java)
    private val id: UUID = UUID.fromString("d58749de-ded2-401b-997f-0e940b8fdc2d")

    lateinit var service: ShoppingCartServiceImpl

    @BeforeEach
    fun setUp() {
        service = ShoppingCartServiceImpl(repository)
        val shoppingCart = ShoppingCart(getProducts(), State.PENDING, id)
        Mockito.`when`(repository.findById(id)).thenReturn(Optional.of(shoppingCart))
    }

    @Test
    fun getProductsByCart() {
        val productsByCart = service.getProductsByCart(id)
        Assertions.assertEquals(productsByCart.size, getProducts().size)
    }

    @Test
    fun checkout() {
        val response = service.checkout(id)
        Assertions.assertEquals(response.finalCost, 479.7)
    }

    private fun getProducts(): MutableList<Product> {
        val product1 = Product("product1", "sku1", "description1", 50.0, 1500, true)
        val product2 = Product("product2", "sku2", "description2", 150.0, 100, false)
        val product3 = Product("product3", "sku3", "description3", 250.20, 150, false)
        val product4 = Product("product4", "sku4", "description4", 52.0, 1300, false)
        val product5 = Product("product5", "sku5", "description5", 5.0, 1540, true)
        return mutableListOf(product1, product2, product3, product4, product5)
    }

}

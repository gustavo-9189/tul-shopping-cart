package com.gmartinez.tulshoppingcart.service

import com.gmartinez.tulshoppingcart.model.Product
import com.gmartinez.tulshoppingcart.model.ShoppingCart
import com.gmartinez.tulshoppingcart.model.State
import com.gmartinez.tulshoppingcart.repository.ShoppingCartRepository
import com.gmartinez.tulshoppingcart.request.ShoppingCartRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

internal class ShoppingCartServiceImplTest {

    private val repository: ShoppingCartRepository = Mockito.mock(ShoppingCartRepository::class.java)
    private val id: UUID = UUID.fromString("d58749de-ded2-401b-997f-0e940b8fdc2d")

    private lateinit var service: ShoppingCartServiceImpl

    @BeforeEach
    fun setUp() {
        service = ShoppingCartServiceImpl(repository)
        val shoppingCart = ShoppingCart(getProducts(), State.PENDING, id)
        Mockito.`when`(repository.findById(id)).thenReturn(Optional.of(shoppingCart))
        Mockito.`when`(repository.save(shoppingCart)).thenReturn(shoppingCart)
    }

    @Test
    fun getProductsByCart_OK() {
        val productsByCart = service.getProductsByCart(id)
        Assertions.assertEquals(productsByCart.size, getProducts().size)
    }

    @Test
    fun addProductToCart_OK() {
        val product = Product(
            "product6", "sku6", "description6", 54.0, 6,
            true
        )
        val request = ShoppingCartRequest(id, product)
        val shoppingCart = service.addProductToCart(request)
        Assertions.assertEquals(shoppingCart.products.size, 6)
    }

    @Test
    fun updateProductToCart_OK() {
        val product = Product("product1", "sku1", "description1",
            50.0, 2, true, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae976"))
        val response = service.updateProductToCart(id, product)
            .products
            .filter { p -> p.id == product.id }[0]
        Assertions.assertEquals(response.amount, 2)
    }

    @Test
    fun deleteProductToCart_OK() {
        val response = service.deleteProductToCart(id, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae976"))
        Assertions.assertEquals(response.products.size, 4)
    }

    @Test
    fun checkout_finalCostOK() {
        val response = service.checkout(id)
        Assertions.assertEquals(response.finalCost, 1610.5)
    }

    private fun getProducts(): MutableList<Product> = mutableListOf(
        Product("product1", "sku1", "description1", 50.0, 6, true, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae976")),
        Product("product2", "sku2", "description2", 150.0, 1, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae977")),
        Product("product3", "sku3", "description3", 250.20, 5, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae978")),
        Product("product4", "sku4", "description4", 52.0, 1, false, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae979")),
        Product("product5", "sku5", "description5", 5.0, 3, true, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae980"))
    )

}

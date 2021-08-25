package com.gmartinez.tulshoppingcart.service

import com.gmartinez.tulshoppingcart.model.Product
import com.gmartinez.tulshoppingcart.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

internal class ProductServiceImplTest {

    private val repository: ProductRepository = Mockito.mock(ProductRepository::class.java)

    private lateinit var service: ProductServiceImpl

    @BeforeEach
    fun setUp() {
        service = ProductServiceImpl(repository)
        val updateProduct = Product(
            "product1", "sku1", "description1",
            50.0, 2, true, UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae976")
        )
        Mockito.`when`(repository.save(updateProduct)).thenReturn(updateProduct)
    }

    @Test
    fun updateProduct_OK() {
        val product = Product("product1", "sku1", "description1", 50.0, 2, true)
        val id = UUID.fromString("90f12171-4678-4b35-8d8d-bbea178ae976")
        val response = service.updateProduct(id, product)
        Assertions.assertEquals(response.id, id)
    }

}

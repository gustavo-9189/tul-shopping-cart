package com.gmartinez.tulshoppingcart.controller

import com.gmartinez.tulshoppingcart.model.Product
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun getProducts_OK() {
        val entity = restTemplate.getForEntity<List<Product>>("/products")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun createProduct_OK() {
        val product = Product("product1", "sku1", "description1", 50.0, 2, true)
        val entity = restTemplate.postForEntity("/products", product, Product::class.java)
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)

        val entityGet = restTemplate.getForEntity<List<Product>>("/products")
        Assertions.assertThat(entityGet.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entityGet.body?.size).isEqualTo(1)
    }

    @Test
    fun updateProduct_OK() {
        val product = Product("product1", "sku1", "description1", 50.0, 2, true)
        restTemplate.put("/products", product, "90f12171-4678-4b35-8d8d-bbea178ae976")
    }

    @Test
    fun deleteProduct_OK() {
        restTemplate.delete("/products", "90f12171-4678-4b35-8d8d-bbea178ae976")
    }

}

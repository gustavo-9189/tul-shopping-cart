package com.gmartinez.tulshoppingcart.controller

import com.gmartinez.tulshoppingcart.model.Product
import com.gmartinez.tulshoppingcart.model.ShoppingCart
import com.gmartinez.tulshoppingcart.request.ShoppingCartRequest
import com.gmartinez.tulshoppingcart.response.CheckoutResponse
import com.gmartinez.tulshoppingcart.service.ShoppingCartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/shopping-carts")
class ShoppingCartController(@Autowired private val service: ShoppingCartService) : BaseController() {

    @GetMapping("/{id}")
    fun getProductsByCart(
        @PathVariable id: UUID
    ) = service.getProductsByCart(id)

    @PostMapping
    fun addProductToCart(
        @Validated @RequestBody shoppingCartRequest: ShoppingCartRequest
    ) = service.addProductToCart(shoppingCartRequest)

    @PutMapping("/{id}")
    fun updateProductToCart(
        @PathVariable id: UUID,
        @Valid @RequestBody product: Product
    ): ShoppingCart = service.updateProductToCart(id, product)

    @DeleteMapping("/{id}/{idProduct}")
    fun deleteProductToCart(
        @PathVariable id: UUID,
        @PathVariable idProduct: UUID
    ): ShoppingCart = service.deleteProductToCart(id, idProduct)

    @GetMapping("/{id}/checkout")
    fun checkout(
        @PathVariable id: UUID
    ): CheckoutResponse = service.checkout(id)

}

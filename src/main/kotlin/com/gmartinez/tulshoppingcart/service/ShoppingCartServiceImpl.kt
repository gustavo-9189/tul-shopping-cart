package com.gmartinez.tulshoppingcart.service

import com.gmartinez.tulshoppingcart.model.Product
import com.gmartinez.tulshoppingcart.model.ShoppingCart
import com.gmartinez.tulshoppingcart.model.State.COMPLETED
import com.gmartinez.tulshoppingcart.repository.ShoppingCartRepository
import com.gmartinez.tulshoppingcart.request.ShoppingCartRequest
import com.gmartinez.tulshoppingcart.response.CheckoutResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShoppingCartServiceImpl(@Autowired private val repository: ShoppingCartRepository) : ShoppingCartService {

    @Value("\${discount-divider}")
    var discountDivider: Int = 2

    override fun getProductsByCart(id: UUID): MutableList<Product> {
        return repository.findById(id)
            .map(ShoppingCart::products)
            .get()
    }

    override fun addProductToCart(shoppingCartRequest: ShoppingCartRequest): ShoppingCart {
        var shoppingCart = ShoppingCart(mutableListOf())
        if (shoppingCartRequest.idShoppingCart != null) {
            shoppingCart = repository.findById(shoppingCartRequest.idShoppingCart).get()
        }
        shoppingCart.products.add(shoppingCartRequest.product)
        return repository.save(shoppingCart)
    }

    override fun updateProductToCart(id: UUID, product: Product): ShoppingCart {
        val shoppingCart = repository.findById(id).get()
        shoppingCart.products.forEach { if (it.id == product.id) it.amount = product.amount }
        return repository.save(shoppingCart)
    }

    override fun deleteProductToCart(id: UUID, idProduct: UUID): ShoppingCart {
        val shoppingCart = repository.findById(id).get()
        shoppingCart.products = shoppingCart.products
            .filterNot { product -> product.id == idProduct }.toMutableList()
        return repository.save(shoppingCart)
    }

    override fun checkout(id: UUID): CheckoutResponse {
        val shoppingCart = repository.findById(id).get()
        val totalWithDiscount = shoppingCart.products
            .filter { it.withDiscount }
            .sumOf { product -> (product.price * product.amount) / discountDivider }
        val totalWithoutDiscount = shoppingCart.products
            .filterNot { it.withDiscount }
            .sumOf { product -> product.price * product.amount }
        shoppingCart.state = COMPLETED
        repository.save(shoppingCart)
        return CheckoutResponse(totalWithDiscount + totalWithoutDiscount)
    }

}

package com.gmartinez.tulshoppingcart.repository

import com.gmartinez.tulshoppingcart.model.ShoppingCart
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShoppingCartRepository : JpaRepository<ShoppingCart, UUID>
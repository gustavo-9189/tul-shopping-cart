package com.gmartinez.tulshoppingcart.repository

import com.gmartinez.tulshoppingcart.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, UUID>
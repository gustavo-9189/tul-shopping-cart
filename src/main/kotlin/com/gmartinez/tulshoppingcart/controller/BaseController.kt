package com.gmartinez.tulshoppingcart.controller

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.HashMap
import java.util.function.Consumer

abstract class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?>? =

        ex.bindingResult.allErrors.fold(mutableMapOf()) { acc, error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            acc[fieldName] = errorMessage
            acc
        }

}

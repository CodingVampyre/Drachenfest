package com.github.codingvampyre.drachenfest.services.password

interface PasswordService {
    fun hash(plain: String): String?
    fun validate(hashedFromDatabase: String, enteredPassword: String): Boolean?
}
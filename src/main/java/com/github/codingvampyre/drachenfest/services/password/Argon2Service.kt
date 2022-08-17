package com.github.codingvampyre.drachenfest.services.password

import de.mkammerer.argon2.Argon2
import de.mkammerer.argon2.Argon2Factory
import de.mkammerer.argon2.Argon2Helper
import org.springframework.stereotype.Service

@Service
class Argon2Service : PasswordService {
    private var argon2: Argon2 = Argon2Factory.create()
    private val iterations = Argon2Helper.findIterations(argon2, 1000, 65536, 1)
    override fun hash(password: String): String {
        return argon2.hash(iterations, 65536, 1, password.toCharArray())
    }

    override fun validate(hashedFromDatabase: String, enteredPassword: String): Boolean {
        return argon2.verify(hashedFromDatabase, enteredPassword.toCharArray())
    }
}
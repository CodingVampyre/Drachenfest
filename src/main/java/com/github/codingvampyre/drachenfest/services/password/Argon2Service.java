package com.github.codingvampyre.drachenfest.services.password;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Helper;
import org.springframework.stereotype.Service;

@Service
public class Argon2Service implements PasswordService {

    Argon2 argon2 = Argon2Factory.create();
    private final int iterations = Argon2Helper.findIterations(argon2, 1000, 65536, 1);

    @Override
    public String hash(String password) {
        return argon2.hash(iterations, 65536, 1, password.toCharArray());
    }

    @Override
    public Boolean validate(String hashedFromDatabase, String enteredPassword) {
        return argon2.verify(hashedFromDatabase, enteredPassword.toCharArray());
    }
}

package com.github.codingvampyre.drachenfest.services.password;

public interface PasswordService {
    public String hash(String plain);
    public Boolean validate(String hashedFromDatabase, String enteredPassword);
}

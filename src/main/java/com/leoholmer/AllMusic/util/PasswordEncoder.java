package com.leoholmer.AllMusic.util;

import org.password4j.Password;

public class PasswordEncoder {
    public String encode(String rawPassword) {
        return Password.hash(rawPassword).withBcrypt();
    }

    public boolean verify(String rawPassword, String encodedPassword) {
        return Password.check(rawPassword, encodedPassword).withBcrypt();
    }
}
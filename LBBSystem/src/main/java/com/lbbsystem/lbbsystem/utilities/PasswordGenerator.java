package com.lbbsystem.lbbsystem.utilities;

import jakarta.ejb.Stateless;

import java.security.SecureRandom;

@Stateless
public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "*.!@$%^&(){}[]:;<>,?/~_+-=|\\";
    private static final String ALL_CHARS = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMERIC_CHARS + SPECIAL_CHARS;

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length) {
        if (length < 8 || length > 32) {
            throw new IllegalArgumentException("Password length must be between 8 and 32 characters.");
        }

        StringBuilder password = new StringBuilder(length);

        password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));
        password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));
        password.append(NUMERIC_CHARS.charAt(random.nextInt(NUMERIC_CHARS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        return password.toString();
    }
}

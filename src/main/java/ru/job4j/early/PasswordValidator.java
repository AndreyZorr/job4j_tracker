package ru.job4j.early;

public class PasswordValidator {
    private static final String[] INVALID_STRINGS = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper = true;
            }
            if (Character.isLowerCase(c)) {
                lower = true;
            }
            if (Character.isDigit(c)) {
                digit = true;
            }
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                special = true;
            }
            if (upper && lower && digit && special) {
                break;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!special) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        for (String s : INVALID_STRINGS) {
            if (password.toLowerCase().contains(s)) {
                throw new IllegalArgumentException(
                        "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}

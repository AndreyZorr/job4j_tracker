package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        boolean checkDigit = false;
        boolean checkSymbol = false;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                checkDigit = true;
                break;
            }
        }
        if (!checkDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                checkSymbol = true;
                break;
            }
        }
        if (!checkSymbol) {
                throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (checkSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
    }
        return password;
}

    public static boolean checkSubstring(String password) {
        String[] passes = {"qwerty", "12345", "password", "admin", "user"};
        for (String str : passes) {
            if (password.toLowerCase().contains(str)) {
                return true;
            }
        } return false;
    }
}
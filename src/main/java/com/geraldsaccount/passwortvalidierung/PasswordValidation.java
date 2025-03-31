/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.geraldsaccount.passwortvalidierung;

/**
 *
 * @author Gerald
 */
public class PasswordValidation {

    public static boolean isValidPassword(String password) {
        return hasValidLength(password) && containsDigit(password) && containsUppercaseAndLowercase(password)
                && !isCommonPassword(password) && containsSpecialCharacters(password)
                && !containsIllegalCharacters(password);
    }

    public static boolean hasValidLength(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean containsUppercaseAndLowercase(String password) {
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
    }

    static final String[] unsafePasswords = {
            "Passw0rd!", "Qwerty123!", "Welcome1!", "Admin123!", "Test1234!",
            "LetMeIn1!", "Changeme1!", "Password1!", "Secure123!", "Abcdefg1!",
            "Summer2024!", "Winter123!", "Hello123!", "Welcome01!", "Football1!",
            "Sunshine1!", "Monkey123!", "Iloveyou1!", "Dragon123!", "Superman1!"
    };

    public static boolean isCommonPassword(String password) {
        for (String commonPassword : unsafePasswords) {
            if (password.equals(commonPassword)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsSpecialCharacters(String password) {
        return password.matches(".*[!#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~].*");
    }

    static boolean containsIllegalCharacters(String password) {
        return password.matches(".*[ ,.'\"\0\t\r\n].*");
    }
}

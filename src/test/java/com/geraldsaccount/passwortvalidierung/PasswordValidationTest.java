package com.geraldsaccount.passwortvalidierung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    // region Password Validation

    @Test
    public void isValidPassword_shouldReturnTrue_whenPasswordIsStrong() {
        String input = "Str0ngP@ss!"; // Complies with each rule
        boolean expected = true;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isValidPassword_shouldReturnFalse_whenPasswordIsTooShort() {
        String input = "A1@b"; // Less than 8 characters
        boolean expected = false;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password too short test: ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isValidPassword_shouldReturnFalse_whenPasswordHasNoDigit() {
        String input = "StrongPass!"; // No digit
        boolean expected = false;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password missing digit test: ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isValidPassword_shouldReturnFalse_whenPasswordHasNoUppercase() {
        String input = "weakpassword1!"; // No uppercase letter
        boolean expected = false;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password missing uppercase test: ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isValidPassword_shouldReturnFalse_whenPasswordHasNoLowercase() {
        String input = "STRONG1!"; // No lowercase letter
        boolean expected = false;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password missing lowercase test: ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isValidPassword_shouldReturnFalse_whenPasswordHasNoSpecialCharacter() {
        String input = "StrongPass1"; // No special character
        boolean expected = false;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password missing special character test: ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isValidPassword_shouldReturnFalse_whenPasswordContainsInvalidCharacters() {
        String input = "Invalid Pass1!"; // Contains space
        boolean expected = false;

        boolean actual = PasswordValidation.isValidPassword(input);

        String testName = "Password contains invalid characters test: ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Password Length

    @Test
    public void hasValidLength_shouldReturnTrue_whenPasswordLengthIsLonger8() {
        String input = "Hello, World!";
        boolean expected = true;

        boolean actual = PasswordValidation.hasValidLength(input);

        String testName = "Length Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void hasValidLength_shouldReturnTrue_whenPasswordLengthIsEquals8() {
        String input = "12345678";
        boolean expected = true;

        boolean actual = PasswordValidation.hasValidLength(input);

        String testName = "Length Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void hasValidLength_shouldReturnFalse_whenPasswordLengthIsLess8() {
        String input = "Hello";
        boolean expected = false;

        boolean actual = PasswordValidation.hasValidLength(input);

        String testName = "Length Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Digit

    @Test
    public void containsDigit_shouldReturnTrue_whenPasswordHasDigit() {
        String input = "123";
        boolean expected = true;

        boolean actual = PasswordValidation.containsDigit(input);

        String testName = "Digit Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsDigit_shouldReturnFalse_whenPasswordHasNoDigit() {
        String input = "ABC";
        boolean expected = false;

        boolean actual = PasswordValidation.containsDigit(input);

        String testName = "Digit Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Upper-/Lowercase

    @Test
    public void containsUppercaseAndLowercase_shouldReturnTrue_whenPasswordHasUpperAndLowercase() {
        String input = "AabBCc";
        boolean expected = true;

        boolean actual = PasswordValidation.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsUppercaseAndLowercase_shouldReturnFalse_whenPasswordHasNoUppercase() {
        String input = "aabbcc";
        boolean expected = false;

        boolean actual = PasswordValidation.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsUppercaseAndLowercase_shouldReturnFalse_whenPasswordHasNoLowercase() {
        String input = "AABBCC";
        boolean expected = false;

        boolean actual = PasswordValidation.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsUppercaseAndLowercase_shouldReturnFalse_whenPasswordHasNoLetter() {
        String input = "123456";
        boolean expected = false;

        boolean actual = PasswordValidation.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Common Passwords

    @Test
    public void isCommonPassword_shouldReturnTrue_whenPasswordIsCommon() {
        String input = "Password1!";
        boolean expected = true;

        boolean actual = PasswordValidation.isCommonPassword(input);

        String testName = "Common Password Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isCommonPassword_shouldReturnFalse_whenPasswordIsNotCommon() {
        String input = "UbisoftIsInBigTrouble";
        boolean expected = false;

        boolean actual = PasswordValidation.isCommonPassword(input);

        String testName = "Common Password Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Special Characters

    @Test
    public void containsSpecialCharacters_shouldReturnTrue_whenPasswordHasSpecialCharacters() {
        String input = "SafePassword?!";
        boolean expected = true;

        boolean actual = PasswordValidation.containsSpecialCharacters(input);

        String testName = "Special Character Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsSpecialCharacters_shouldReturnTrue_whenPasswordHasOneSpecialCharacter() {
        String input = "SafePassword!";
        boolean expected = true;

        boolean actual = PasswordValidation.containsSpecialCharacters(input);

        String testName = "Special Character Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsSpecialCharacters_shouldReturnFalse_whenPasswordHasNoSpecialCharacters() {
        String input = "SafePassword";
        boolean expected = false;

        boolean actual = PasswordValidation.containsSpecialCharacters(input);

        String testName = "Special Character Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Illegal Characters

    @Test
    public void containsIllegalCharacters_shouldReturnTrue_whenPasswordHasIllegalCharacters() {
        String input = "Safe Password.";
        boolean expected = true;

        boolean actual = PasswordValidation.containsIllegalCharacters(input);

        String testName = "Special Character Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsIllegalCharacters_shouldReturnFalse_whenPasswordHasNoIllegalCharacters() {
        String input = "SafePassword";
        boolean expected = false;

        boolean actual = PasswordValidation.containsIllegalCharacters(input);

        String testName = "Special Character Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion
}

package com.geraldsaccount.passwortvalidierung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PasswortValidierungTest {

    // region Password Length

    @Test
    public void hasValidLength_shouldReturnTrue_calledWithHelloWorld() {
        String input = "Hello, World!";
        boolean expected = true;

        boolean actual = PasswortValidierung.hasValidLength(input);

        String testName = "Length Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void hasValidLength_shouldReturnTrue_calledWith12345678() {
        String input = "12345678";
        boolean expected = true;

        boolean actual = PasswortValidierung.hasValidLength(input);

        String testName = "Length Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void hasValidLength_shouldReturnFalse_calledWithHello() {
        String input = "Hello";
        boolean expected = false;

        boolean actual = PasswortValidierung.hasValidLength(input);

        String testName = "Length Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Digit

    @Test
    public void containsDigit_shouldReturnTrue_calledWith123() {
        String input = "123";
        boolean expected = true;

        boolean actual = PasswortValidierung.containsDigit(input);

        String testName = "Digit Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsDigit_shouldReturnFalse_calledWithABC() {
        String input = "ABC";
        boolean expected = false;

        boolean actual = PasswortValidierung.containsDigit(input);

        String testName = "Digit Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Upper-/Lowercase

    @Test
    public void containsUppercaseAndLowercase_shouldReturnTrue_calledWithAabBCc() {
        String input = "AabBCc";
        boolean expected = true;

        boolean actual = PasswortValidierung.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsUppercaseAndLowercase_shouldReturnFalse_calledWithaabbcc() {
        String input = "aabbcc";
        boolean expected = false;

        boolean actual = PasswortValidierung.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void containsUppercaseAndLowercase_shouldReturnFalse_calledWith123456() {
        String input = "123456";
        boolean expected = false;

        boolean actual = PasswortValidierung.containsUppercaseAndLowercase(input);

        String testName = "Upper-/Lowercase Validation Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion

    // region Common Passwords

    @Test
    public void isCommonPassword_shouldReturnTrue_calledWithPassword1() {
        String input = "Password1!";
        boolean expected = true;

        boolean actual = PasswortValidierung.isCommonPassword(input);

        String testName = "Common Password Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void isCommonPassword_shouldReturnFalse_whenPasswordIsNotCommon() {
        String input = "UbisoftIsInBigTrouble";
        boolean expected = false;

        boolean actual = PasswortValidierung.isCommonPassword(input);

        String testName = "Common Password Test ";
        assertEquals(expected, actual,
                () -> testName + "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    // endregion
}

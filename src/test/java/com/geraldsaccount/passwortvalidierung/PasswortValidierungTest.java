package com.geraldsaccount.passwortvalidierung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PasswortValidierungTest {

    @Test
    public void hasValidLength_shouldReturnTrue_calledWithHelloWorld() {
        String input = "Hello, World!";
        boolean expected = true;

        boolean actual = PasswortValidierung.hasValidLength(input);

        assertEquals(expected, actual, () -> "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void hasValidLength_shouldReturnTrue_calledWith12345678() {
        String input = "12345678";
        boolean expected = true;

        boolean actual = PasswortValidierung.hasValidLength(input);

        assertEquals(expected, actual, () -> "Expected " + expected + " but got " + actual + " for input: " + input);
    }

    @Test
    public void hasValidLength_shouldReturnFalse_calledWithHello() {
        String input = "Hello";
        boolean expected = false;

        boolean actual = PasswortValidierung.hasValidLength(input);

        assertEquals(expected, actual, () -> "Expected " + expected + " but got " + actual + " for input: " + input);
    }

}

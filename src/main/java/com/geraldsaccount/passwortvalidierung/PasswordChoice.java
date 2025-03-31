package com.geraldsaccount.passwortvalidierung;

import java.util.Scanner;

public class PasswordChoice {
    private static String password;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            createPassword(scanner);

            int selection;
            boolean exit = false;

            while (!exit) {
                selection = getMenuSelection(scanner);
                switch (selection) {
                    case 1 -> {
                        if (checkPassword(scanner)) {
                            System.out.println("You have been logged in successfully.");
                            exit = true;
                        }
                    }
                    case 2 -> createPassword(scanner);
                    default -> exit = true;
                }

            }
        }
    }

    public static void createPassword(Scanner scanner) {
        boolean wantsCustomPassword = getCustomPasswordChoice(scanner);

        password = wantsCustomPassword ? choosePassword(scanner) : PasswordGeneration.generatePassword();
        System.out.println("Your secure password is: " + password);
    }

    public static boolean getCustomPasswordChoice(Scanner scanner) {
        System.out.print("Do you want to choose your password? If not a password will be generated. y/n ");

        String input;
        do {
            input = scanner.nextLine().toLowerCase();
        } while (!input.equals("y") && !input.equals("n"));

        return input.equals("y");
    }

    public static String choosePassword(Scanner scanner) {
        String selectedPassword;
        boolean isSecure = false;
        do {
            System.out.print("Choose your password: ");
            selectedPassword = scanner.nextLine();

            if (selectedPassword.equals(password)) {
                System.out.println("Your password has to be different than your previous password.");
                continue;
            }

            if (PasswordValidation.isValidPassword(selectedPassword)) {
                break;
            }

            if (!PasswordValidation.hasValidLength(selectedPassword)) {
                System.out.println("Your password must be at least 8 characters long.");
            }

            if (!PasswordValidation.containsUppercaseAndLowercase(selectedPassword)) {
                System.out.println("Your password must contain both uppercase and lowercase letters.");
            }

            if (!PasswordValidation.containsDigit(selectedPassword)) {
                System.out.println("Your password must contain at least one digit.");
            }

            if (!PasswordValidation.containsSpecialCharacters(selectedPassword)) {
                System.out.println("Your password must contain at least one special character.");
            }

            if (PasswordValidation.containsIllegalCharacters(selectedPassword)) {
                System.out.println("Your password contains illegal characters (e.g., spaces, commas, backslashes).");
            }

            if (PasswordValidation.isCommonPassword(selectedPassword)) {
                System.out.println("Your password is too common.");
            }

        } while (!isSecure);

        return selectedPassword;
    }

    public static int getMenuSelection(Scanner scanner) {
        System.out.println("What do you want to do?\n1. Login\n2. Change Password\n3. Quit");

        String pressedKey;

        do {
            pressedKey = scanner.nextLine();
        } while (!pressedKey.equals("1") && !pressedKey.equals("2") && !pressedKey.equals("3"));

        return Integer.parseInt(pressedKey);
    }

    public static boolean checkPassword(Scanner scanner) {
        System.out.print("Please enter your password: ");
        String input = scanner.nextLine();

        if (!input.equals(password)) {
            System.out.println("Your password was incorrect.");
        }

        return input.equals(password);
    }
}

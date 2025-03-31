package com.geraldsaccount.passwortvalidierung;

import java.util.Random;

public class PasswordGeneration {
    public static void main(String[] args) {
        System.out.println(generatePassword());
    }

    public static String generatePassword() {
        String lowerCase = "abcdefghijkmnpqrstuvwxyz";
        String upperCase = "ABCDEFGHJKLMNPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialCharacters = "!#$%&'()*+-/:;<=>?@[]^_{|}~";

        String password = "";

        Random random = new Random();
        int segmentCount = random.nextInt(2, 4);
        int segmentLength = random.nextInt(4, 6);

        do {
            password = "";
            for (int i = 0; i < segmentCount; i++) {
                for (int j = 0; j < segmentLength; j++) {
                    double r = random.nextDouble();
                    if (r < 0.5) {
                        password += randomCharacter(lowerCase, random);
                    } else if (r < 0.75) {
                        password += randomCharacter(upperCase, random);
                    } else if (r < 0.99) {
                        password += randomCharacter(digits, random);
                    } else {
                        password += randomCharacter(specialCharacters, random);
                    }
                }
                if (i == segmentCount - 1) {
                    break;
                }
                password += "-";
            }
        } while (!PasswordValidation.isValidPassword(password));

        return password;
    }

    private static char randomCharacter(String source, Random random) {
        return source.charAt(random.nextInt(0, source.length()));
    }
}

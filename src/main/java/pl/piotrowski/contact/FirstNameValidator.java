package pl.piotrowski.contact;

import java.util.Scanner;

public class FirstNameValidator {
    public static String firstNameValidation(String firstName) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
            while (valid) {
                valid = firstName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
                System.out.println("Imie: " + firstName);
                if (valid == true) {
                    firstName = firstName;
                    break;
                } else System.out.println("Podaj poprawnie imie");
                 firstName = scanner.nextLine();
                 valid = true;
            }
        return firstName;
    }
}
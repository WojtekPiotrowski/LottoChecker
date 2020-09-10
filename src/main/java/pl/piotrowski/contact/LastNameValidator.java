package pl.piotrowski.contact;

import java.util.Scanner;

public class LastNameValidator {
    public static String lastNameValidation(String lastName) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        while (valid) {
            valid = lastName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
            System.out.println("Nazwisko: " + lastName);
            if (valid == true) {
                lastName = lastName;
                break;
            } else System.out.println("Podaj poprawnie nazwisko");
            lastName = scanner.nextLine();
            valid = true;
        }
        return lastName;
    }
}

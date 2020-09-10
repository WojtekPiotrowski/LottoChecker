package pl.piotrowski.contact;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidator {
    public static String emailValidation(String email) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        while (valid) {
            valid = email.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
            System.out.println("Email: " + email);
            if (valid == true) {
                email = email;
                break;
            } else System.out.println("Podaj poprawnie email");
            email = scanner.nextLine();
            valid = true;
        }
        return email;
    }

}

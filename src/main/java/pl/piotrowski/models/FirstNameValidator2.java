package pl.piotrowski.models;

import java.util.Scanner;
public class FirstNameValidator2 {
   public static boolean firstNameValidation(String firstName) {
      Scanner scanner = new Scanner(System.in);
      boolean valid = false;
      valid = firstName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
      System.out.println("Imie: " + firstName);

      while (valid) {
         System.out.println("Podaj poprawnie imie");
         firstName=scanner.nextLine();
      }
      return valid;
   }
}
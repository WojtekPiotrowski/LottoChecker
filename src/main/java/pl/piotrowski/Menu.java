package pl.piotrowski;

import pl.piotrowski.checkResult.ScannerInputSource;
import pl.piotrowski.checkResult.UserInput;

import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        boolean continuing = true;
        while (continuing) {
            System.out.println("Witamy w aplikacji lotto");
            System.out.println("Wybierz jedną z opcji : ");
            System.out.println("1. Lotto");
            System.out.println("2. Lotto Plus");
            System.out.println("3. Super szansa");
            System.out.println("4. Mini-lotto");
            System.out.println("0. aby zakończyć grę");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            switch (answer) {
                case 0: {
                    continuing = false;
                    break;

                }
                case 1: {
                    lottoMenu();
                }


            }


        }
    }

    private static void lottoMenu() {
        boolean continuing = true;
        while (continuing) {
            System.out.println("Wybrałeś lotto");
            System.out.println("Wybierz jedną z opcji : ");
            System.out.println("1. Wpisz swoje szczęśliwe liczby");
            System.out.println("2. Wylosuj te liczby");
            System.out.println("3. Wczytaj liczby z pliku");
            System.out.println("4. Wyświetl historię gier");
            System.out.println("0. aby powrócić do menu głównego");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            switch (answer) {
                case 0: {
                    continuing = false;
                    break;

                }
                case 1: {
                    ScannerInputSource scannerInputSource = new ScannerInputSource();
                    UserInput userInput = new UserInput(scannerInputSource);
                    int[] sortedNumbers = userInput.getSortedNumbers();
                    System.out.println("Wpisałeś takie liczby: ");
                    for (int liczby : sortedNumbers){
                        System.out.print(liczby);
                    }
                    break;
                }
                default:{
                    System.out.println("Nie ma takiego numeru");
                }


            }


        }
    }


}

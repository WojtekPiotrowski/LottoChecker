package pl.piotrowski;

import pl.piotrowski.checkResult.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    break;
                }
                case 2: {
                    lottoPlusMenu();
                    break;
                }
                case 3: {
                    superSzansaMenu();
                    break;
                }
                case 4: {
                    miniLottoMenu();
                    break;
                }
            }
        }
    }

    private static void lottoMenu() {
        genericLottoMenu(GameType.LOTTO);
    }

    private static void lottoPlusMenu() {
        genericLottoMenu(GameType.LOTTO_PLUS);
    }

    private static void miniLottoMenu() {
        genericLottoMenu(GameType.MINI_LOTTO);
    }

    private static void genericLottoMenu(GameType gameType) {
        boolean continuing = true;

        String gameName = gameType.toString(); //"MINI_LOTTO"

        while (continuing) {
            System.out.println("Wybrałeś " + gameName);
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
                    loadFromInputAndCheckWinner(new ScannerInputSource(), gameType);
                    break;
                }
                case 2: {
                    loadFromInputAndCheckWinner(new RandomNumberGenerator(gameType), gameType);
                    break;
                }
                case 3: {
                    loadFromInputAndCheckWinner(new FileInputSource(), gameType);
                    break;
                }
                default: {
                    System.out.println("Nie ma takiego numeru");
                }
            }
        }
    }

    private static void loadFromInputAndCheckWinner(InputSource inputSource, GameType gameType) {
        NumbersChecker numbersChecker = new NumbersChecker(inputSource);
        List<Integer> matchNumbers = new ArrayList<>();

        if (gameType.equals(GameType.LOTTO)) {
            matchNumbers = numbersChecker.checkLottoGame();
        } else if (gameType.equals(GameType.LOTTO_PLUS)) {
            matchNumbers = numbersChecker.checkLottoPlusGame();
        } else if (gameType.equals(GameType.MINI_LOTTO)) {
            matchNumbers = numbersChecker.checkMiniLottoGame();
        }

        System.out.println("pasujące liczby to: ");
        System.out.println(matchNumbers);
        System.out.println("Trafiłeś " + matchNumbers.size() + " liczb z " + gameType.maxNumbers);

        if (matchNumbers.size() == gameType.maxNumbers) {
            System.out.println("Brawo zostałeś milionerem");
        }
    }

    private static void superSzansaMenu() {
        System.out.println("Not implemented yet");
    }
}

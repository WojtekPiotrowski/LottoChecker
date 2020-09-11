package pl.piotrowski;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.piotrowski.checkResult.*;
import pl.piotrowski.contact.EmailValidator;
import pl.piotrowski.contact.FirstNameValidator;
import pl.piotrowski.contact.LastNameValidator;
import pl.piotrowski.contact.User;

import java.util.ArrayList;
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
            System.out.println("5. Kontakt");
            System.out.println("0. aby zakończyć grę");
            Scanner scanner = new Scanner(System.in);
            int answer = -1;

            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            }
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
                case 5: {
                    System.out.println("Wybrales formularz kontaktowy");
                    System.out.println("Podaj imie bez polkich znakow ");
                    Scanner scanner1 = new Scanner(System.in);
                    String firstName = scanner1.nextLine();
                    FirstNameValidator.firstNameValidation(firstName);
//                    User user = new User(firstName, null, null);
//                    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//                    Metadata metadata = new MetadataSources(registry).buildMetadata();
//                    SessionFactory factory = metadata.buildSessionFactory();
//                    Session session = factory.openSession();
//
//                    Transaction transaction = session.beginTransaction();
//
//                    session.save(user);
//                    transaction.commit();
//
//                    //Zamkniecie polaczenia z baza danych
//                    session.close();
//                    factory.close();

                    System.out.println("Podaj nazwisko bez polich znaków");
                    Scanner scanner2 = new Scanner(System.in);
                    String lastName = scanner2.nextLine();
                    LastNameValidator.lastNameValidation(lastName);
                    System.out.println("podaj adres email");
                    Scanner scanner3 = new Scanner(System.in);
                    String email = scanner3.nextLine();
                    EmailValidator.emailValidation(email);

                    User user = new User(firstName, lastName, email);

                    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                    Metadata metadata = new MetadataSources(registry).buildMetadata();
                    SessionFactory factory = metadata.buildSessionFactory();
                    //Zapisanie modelu do bazy danych
                    Session session = factory.openSession();
                    Transaction transaction = session.beginTransaction();
                    session.save(user);
                    transaction.commit();
                    //Zamkniecie polaczenia z baza danych
                    session.close();
                    factory.close();


                }
            }
        }
    }

    private static void lottoMenu() {
        genericLottoMenu(GameType.LOTTO);
    }

    private static void contact() {
        genericLottoMenu(GameType.FORMULARZ_KONTAKTOWY);
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
            int answer = -1;

            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            }

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
        try {

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
        } catch (NumberValidationException | LottoFileNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private static void superSzansaMenu() {
        System.out.println("Not implemented yet");
    }
}

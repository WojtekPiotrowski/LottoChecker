package pl.piotrowski.checkResult;

import pl.piotrowski.PropertiesManager;

import java.util.Scanner;

public class ScannerInputSource implements InputSource {
    private final Scanner scanner;

    public ScannerInputSource() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        System.out.println("Podaj swoje liczby oddzielajace je znakiem: " + PropertiesManager.getProperty("NUMBER_SEPARATOR"));
        return scanner.nextLine();
    }
}

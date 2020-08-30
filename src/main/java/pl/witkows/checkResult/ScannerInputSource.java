package pl.witkows.checkResult;

import java.util.Scanner;

public class ScannerInputSource implements InputSource {
    private final Scanner scanner;

    public ScannerInputSource() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        System.out.println("Podaj swoje liczby oddzielajace je przecinkami");
        return scanner.nextLine();
    }
}

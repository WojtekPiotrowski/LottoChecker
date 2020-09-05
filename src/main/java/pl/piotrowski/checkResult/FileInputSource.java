package pl.piotrowski.checkResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputSource implements InputSource {
    private static final String FILE_NAME = "liczby.txt";
    private final File file;

    public FileInputSource() {
        file = new File(FILE_NAME);
    }

    @Override
    public String getInput() {
        System.out.println("Wczytuje liczby z pliku " + FILE_NAME);
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }

            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Nie udalo sie otworzyc pliku");
            return "";
        }
    }
}

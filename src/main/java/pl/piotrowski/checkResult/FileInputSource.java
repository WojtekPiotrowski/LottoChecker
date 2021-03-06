package pl.piotrowski.checkResult;

import pl.piotrowski.PropertiesManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputSource implements InputSource {

    private final File file;

    public FileInputSource() {
        file = new File(PropertiesManager.getProperty("FILE_NAME"));
    }

    @Override
    public String getInput() throws LottoFileNotFound {
        System.out.println("Wczytuje liczby z pliku " + PropertiesManager.getProperty("FILE_NAME"));
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            //TODO wiele liczb z pliku, rozróżnić czy mini czy plus (liczba liczb?)

            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new LottoFileNotFound("Pod daną ścieżką nie znaleziono pliku");
        }
    }
}

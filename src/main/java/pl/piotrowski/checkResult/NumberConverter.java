package pl.piotrowski.checkResult;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.piotrowski.AppConfig;

public class NumberConverter {

    private NumberConverter() {

    }

    @NotNull
    public static int[] parseToIntTab(@Nullable String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new int[0];
        }

        String[] numbersTab = numbers.split(AppConfig.NUMBER_SEPARATOR);
        int[] result = new int[numbersTab.length];

        for (int i = 0; i < numbersTab.length; i++) {
            result[i] = tryParseNumber(numbersTab[i]);
        }
        return result;
    }

    private static int tryParseNumber(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

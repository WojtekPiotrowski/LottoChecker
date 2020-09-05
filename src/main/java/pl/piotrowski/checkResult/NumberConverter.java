package pl.piotrowski.checkResult;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.piotrowski.PropertiesManager;

public class NumberConverter {

    private NumberConverter() {

    }

    @NotNull
    public static int[] parseToIntTab(@Nullable String numbers) throws NumberValidationException {
        if (numbers == null || numbers.isEmpty()) {
            return new int[0];
        }

        String[] numbersTab = numbers.split(PropertiesManager.getProperty("NUMBER_SEPARATOR"));
        int[] result = new int[numbersTab.length];

        for (int i = 0; i < numbersTab.length; i++) {
            result[i] = tryParseNumber(numbersTab[i]);
        }
        return result;
    }

    private static int tryParseNumber(String s) throws NumberValidationException {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new NumberValidationException("Podano niewłaściwe liczby!");
        }
    }
}

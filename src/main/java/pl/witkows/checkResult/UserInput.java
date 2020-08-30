package pl.witkows.checkResult;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class UserInput {
    public static final String NUMBER_SEPARATOR = ",";
    private final InputSource inputSource;

    public UserInput(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public int[] getSortedNumbers() {
        String numbers = inputSource.getInput();
        int[] result = parseToIntTab(numbers);
        Arrays.sort(result);
        return result;
    }

    @NotNull
    private int[] parseToIntTab(@Nullable String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new int[0];
        }

        String[] numbersTab = numbers.split(NUMBER_SEPARATOR);
        int[] result = new int[numbersTab.length];

        for (int i = 0; i < numbersTab.length; i++) {
            result[i] = Integer.parseInt(numbersTab[i]);
        }
        return result;
    }

}

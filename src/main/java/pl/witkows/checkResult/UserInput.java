package pl.witkows.checkResult;

import java.util.Arrays;

public class UserInput {
    private final InputSource inputSource;

    public UserInput(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public int[] getSortedNumbers() {
        String numbers = inputSource.getInput();
        int[] result = NumberConverter.parseToIntTab(numbers);
        Arrays.sort(result);
        return result;
    }
}

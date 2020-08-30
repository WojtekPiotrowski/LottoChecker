package pl.witkows;

import pl.witkows.checkResult.*;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputSource source = new RandomNumberGenerator(GameType.LOTTO);
        NumbersChecker numbersChecker = new NumbersChecker(source);
        List<Integer> winNumbers = numbersChecker.checkLottoGame();
        System.out.println(winNumbers);
    }
}

package pl.witkows.checkResult;

import pl.witkows.AppConfig;

import java.util.Random;

public class RandomNumberGenerator implements InputSource {
    private static final int MAX_RANGE_IN_GAME = 46;
    private static final int MIN_RANGE_IN_GAME = 1;
    private final GameType type;
    private final Random random;

    public RandomNumberGenerator(GameType type) {
        this.type = type;
        this.random = new Random();
    }

    @Override
    public String getInput() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < type.maxNumbers; i++) {
            stringBuilder.append(getRandomNumber());
            if (i < type.maxNumbers - 1) {
                stringBuilder.append(AppConfig.NUMBER_SEPARATOR);
            }
        }

        return stringBuilder.toString();
    }

    private int getRandomNumber() {
        return random.nextInt((MAX_RANGE_IN_GAME - MIN_RANGE_IN_GAME) + 1) + MIN_RANGE_IN_GAME;
    }
}

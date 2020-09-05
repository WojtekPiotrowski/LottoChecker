package pl.piotrowski.checkResult;

import pl.piotrowski.AppConfig;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class RandomNumberGenerator implements InputSource {
    private static final int MAX_RANGE_IN_GAME = 49;
    private static final int MIN_RANGE_IN_GAME = 1;
    private final GameType type;
    private final Random random;

    public RandomNumberGenerator(GameType type) {
        this.type = type;
        this.random = new Random();
    }

    @Override
    public String getInput() {
        HashSet<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() != type.maxNumbers) {
            randomNumbers.add(getRandomNumber());
        }
        StringBuilder stringBuilder = new StringBuilder();
        randomNumbers.forEach(s -> stringBuilder.append(s).append(AppConfig.NUMBER_SEPARATOR));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        System.out.println("Twoje losowe liczby to: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    private int getRandomNumber() {
        return random.nextInt((MAX_RANGE_IN_GAME - MIN_RANGE_IN_GAME) + 1) + MIN_RANGE_IN_GAME;
    }
}

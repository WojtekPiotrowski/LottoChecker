package pl.piotrowski.checkResult;

public enum GameType {
    LOTTO(6),
    MINI_LOTTO(5);

    public final int maxNumbers;

    GameType(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }
}

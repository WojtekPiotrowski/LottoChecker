package pl.piotrowski.checkResult;

public enum GameType {
    LOTTO(6),
    LOTTO_PLUS(6),
    MINI_LOTTO(5),
    FORMULARZ_KONTAKTOWY(10);

    public final int maxNumbers;

    GameType(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }
}

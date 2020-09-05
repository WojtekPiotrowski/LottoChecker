package pl.piotrowski.checkResult;

import pl.piotrowski.api.LottoGamesApi;
import pl.piotrowski.models.Game;
import pl.piotrowski.models.Games;

import java.util.ArrayList;
import java.util.List;

public class NumbersChecker {
    private final LottoGamesApi gamesApi;
    private final UserInput userinput;

    public NumbersChecker(InputSource source) {
        gamesApi = new LottoGamesApi();
        userinput = new UserInput(source);
    }

    public List<Integer> checkLottoGame() {
        Games games = gamesApi.getNewestGames();
        return checkGame(games.getLotto());
    }

    public List<Integer> checkMiniLottoGame() {
        Games games = gamesApi.getNewestGames();
        return checkGame(games.getMini());
    }

    public List<Integer> checkGame(Game game) {
        int[] gameNumbers = game.getSortedNumbers();
        int[] userNumbers = userinput.getSortedNumbers();
        List<Integer> winNumbers = new ArrayList<>(gameNumbers.length);

        for (int gameNumber : gameNumbers) {
            for (int userNumber : userNumbers) {
                if (gameNumber == userNumber) {
                    winNumbers.add(gameNumber);
                }
            }
        }

        return winNumbers;
    }
}

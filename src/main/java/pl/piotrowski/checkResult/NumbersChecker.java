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

    public List<Integer> checkLottoGame() throws NumberValidationException, LottoFileNotFound {
        Games games = gamesApi.getNewestGames();
        return checkGame(games.getLotto(),GameType.LOTTO);
    }

    public List<Integer> checkLottoPlusGame() throws NumberValidationException, LottoFileNotFound {
        Games games = gamesApi.getNewestGames();
        return checkGame(games.getLottoPlus(),GameType.LOTTO_PLUS);
    }

    public List<Integer> checkMiniLottoGame() throws NumberValidationException, LottoFileNotFound {
        Games games = gamesApi.getNewestGames();
        return checkGame(games.getMini(),GameType.MINI_LOTTO);
    }

    private List<Integer> checkGame(Game game,GameType type) throws NumberValidationException, LottoFileNotFound {
        int[] gameNumbers = game.getSortedNumbers();
        int[] userNumbers = userinput.getSortedNumbers();


        ValidationNumbers.validateUserNumbers(userNumbers, type);



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

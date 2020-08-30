package pl.witkows;

import pl.witkows.api.GamesApi;
import pl.witkows.api.LottoGamesApi;
import pl.witkows.models.Games;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GamesApi cloudApi = new LottoGamesApi();
        Games games = cloudApi.getNewestGames();
        System.out.println(games.getLotto().getNumerki());
    }
}

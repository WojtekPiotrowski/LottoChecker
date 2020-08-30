package pl.witkows.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.witkows.api.coverter.JsonDataConverter;
import pl.witkows.models.Games;

import java.io.IOException;

public class LottoGamesApi implements GamesApi {
    private final Requester requester;
    private final JsonDataConverter dataConverter;
    private final OkHttpClient httpClient;

    public LottoGamesApi() {
        httpClient = HttpClientProvider.INSTANCE.getClient();
        requester = new Requester();
        dataConverter = new JsonDataConverter();
    }

    @Override
    public Games getNewestGames() {
        try {
            Request request = requester.getNewRequest();
            Response response = httpClient.newCall(request).execute();
            return dataConverter.convert(response.body().string());
        } catch (IOException exception) {
            System.out.println("Ups.. cos poszlo nie tak " + exception.getMessage());
            return new Games();
        }
    }
}

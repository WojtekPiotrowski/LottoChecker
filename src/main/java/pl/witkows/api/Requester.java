package pl.witkows.api;

import okhttp3.Request;

public class Requester {
    private static final String ENDPOINT_URL = "http://serwis.mobilotto.pl/mapi_v7/index.php?json=getGames";

    public Request getNewRequest() {
        return new Request.Builder()
                .url(ENDPOINT_URL)
                .build();
    }
}

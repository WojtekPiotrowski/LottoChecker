package pl.piotrowski.api;

import okhttp3.Request;
import static pl.piotrowski.AppConfig.ENDPOINT_URL;

public class Requester {

    public Request getNewRequest() {
        return new Request.Builder()
                .url(ENDPOINT_URL)
                .build();
    }
}

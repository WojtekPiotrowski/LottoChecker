package pl.piotrowski.api;

import okhttp3.Request;
import pl.piotrowski.PropertiesManager;

public class Requester {

    public Request getNewRequest() {
        return new Request.Builder()
                .url(PropertiesManager.getProperty("ENDPOINT_URL"))
                .build();
    }
}

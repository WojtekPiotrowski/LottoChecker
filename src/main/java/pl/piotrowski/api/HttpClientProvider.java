package pl.piotrowski.api;

import okhttp3.OkHttpClient;

public enum HttpClientProvider {
    INSTANCE;

    private OkHttpClient client;

    HttpClientProvider() {
        client = new OkHttpClient();
    }

    public OkHttpClient getClient() {
        return client;
    }
}

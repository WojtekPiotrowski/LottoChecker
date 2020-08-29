package pl.piotrowski;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder()
                .url("http://serwis.mobilotto.pl/mapi_v6/index.php?json=getGames")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        System.out.println("respons = " + jsonString);

    }
}

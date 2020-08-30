package pl.piotrowski;

import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.piotrowski.models.GameData;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static  Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }
    }).create();

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://serwis.mobilotto.pl/mapi_v6/index.php?json=getGames")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();

        GameData games = gson.fromJson(jsonString, GameData.class);
        games.getLotto().getNumerki();

        System.out.println("Numery duzego lotka to: " + games.getLotto().getNumerki());
    }
}
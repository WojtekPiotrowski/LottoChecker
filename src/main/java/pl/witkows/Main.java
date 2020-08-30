package pl.witkows;

import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.witkows.api.HttpClientProvider;
import pl.witkows.api.User;
import pl.witkows.checkResult.FileInputSource;
import pl.witkows.checkResult.ScannerInputSource;
import pl.witkows.checkResult.UserInput;
import pl.witkows.models.Games;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }
    }).create();

    public static void main(String[] args) throws IOException {
        OkHttpClient client1 = HttpClientProvider.INSTANCE.getClient();

        //
//        Response response = client.newCall(request).execute();
//        String jsonString = response.body().string();
//
//        Games games = gson.fromJson(jsonString, Games.class);
//
//        System.out.println("podaj twoje liczby oddzielajac przecinkiem");
//
//        UserInput userInput = new UserInput(new FileInputSource());
//        int[] sortedNumbers = userInput.getSortedNumbers();
//
//        System.out.println(Arrays.toString(sortedNumbers));
    }
}

package pl.piotrowski.api.coverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.piotrowski.models.Games;

import java.time.LocalDateTime;

public class JsonDataConverter implements DataConverter<Games> {
    private final Gson gson;

    public JsonDataConverter() {
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .create();
    }

    @Override
    public Games convert(String data) {
        return gson.fromJson(data, Games.class);
    }
}

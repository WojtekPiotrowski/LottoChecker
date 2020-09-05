package pl.piotrowski.api.coverter;

public interface DataConverter<T> {
    T convert(String data);
}

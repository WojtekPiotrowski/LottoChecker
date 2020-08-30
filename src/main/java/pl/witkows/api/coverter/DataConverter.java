package pl.witkows.api.coverter;

public interface DataConverter<T> {
    T convert(String data);
}

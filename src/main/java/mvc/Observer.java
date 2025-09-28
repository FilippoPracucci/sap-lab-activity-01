package mvc;

public interface Observer<T> {
    void onChange(T value);
}

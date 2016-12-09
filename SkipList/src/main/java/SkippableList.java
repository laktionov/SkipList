interface SkippableList<T> {
    int LEVELS = 4;

    T get(int key);
    void put(int key, T value);
}

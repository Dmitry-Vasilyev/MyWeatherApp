package com.example.dimav.myweatherapp.utils.mappers;

public interface MapperBase<T, V> {
    void setStrategy(MapperStrategy<T, V> strategy);

    T from(V item);

    interface MapperStrategy<T, V> {
        T execute(V item);
    }
}

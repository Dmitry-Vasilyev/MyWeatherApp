package com.example.dimav.myweatherapp.utils.mappers;

public class Mapper<T, V> implements MapperBase<T, V> {

    private MapperStrategy<T, V> strategy;

    public Mapper(MapperStrategy<T, V> strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setStrategy(MapperStrategy<T, V> strategy) {
        this.strategy = strategy;
    }

    @Override
    public T from(V item) {
        return strategy.execute(item);
    }
}

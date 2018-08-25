package com.example.dimav.myweatherapp.utils;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskIoThreadExecutor implements Executor{

    private final Executor diskIO;

    public DiskIoThreadExecutor() {
        this.diskIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        diskIO.execute(runnable);
    }
}

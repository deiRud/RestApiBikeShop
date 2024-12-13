package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BikeServiceImpl implements BikeService{
    private final Map<String, Bike> bikeStore = new HashMap<>();

    @Override
    public Collection<Bike> getAllBikes() {
        return bikeStore.values();
    }

    @Override
    public Bike getBikeById(String id) {
        return bikeStore.get(id);
    }
}

package org.example;

import java.util.Collection;

public interface BikeService {

    Collection<Bike> getAllBikes ();
    Bike getBikeById(String id);
}

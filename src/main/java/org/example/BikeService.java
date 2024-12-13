package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;

public interface BikeService {

    Collection<Bike> getAllBikes ();
    Bike getBikeById(String id);
}

package org.example;
import com.google.gson.Gson;
import static spark.Spark.*;

public class SparkRestExample {
    public static void main(String[] args){
        BikeService bikeService = new BikeServiceImpl();

        get("/bikes", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(bikeService.getAllBikes()))
            );
        });


        get("/bikes/:id", (request, response) -> {
            response.type("application/json");
            Bike bike = bikeService.getBikeById(request.params(":id"));
            if (bike != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                .toJsonTree(bike))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, "Bike not found")
                );
            }
        });



    }
}

package com.taras.shortway.server.customserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.taras.shortway.server.entity.Trip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomTripsListSerializer extends StdSerializer<List<Trip>> {

    public CustomTripsListSerializer() {
        this(null);
    }

    public CustomTripsListSerializer(Class<List<Trip>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Trip> tripList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Trip trip : tripList) {
            ids.add(trip.getId());
        }
        jsonGenerator.writeObject(ids);
    }
}

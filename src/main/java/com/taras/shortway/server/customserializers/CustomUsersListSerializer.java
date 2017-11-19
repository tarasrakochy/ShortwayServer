package com.taras.shortway.server.customserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.taras.shortway.server.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomUsersListSerializer extends StdSerializer<List<User>> {

    public CustomUsersListSerializer() {
        this(null);
    }

    public CustomUsersListSerializer(Class<List<User>> t) {
        super(t);
    }

    @Override
    public void serialize(List<User> userList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ArrayList<Integer> ids = new ArrayList<>();
        for (User user : userList) {
            ids.add(user.getId());
        }
        jsonGenerator.writeObject(ids);
    }
}

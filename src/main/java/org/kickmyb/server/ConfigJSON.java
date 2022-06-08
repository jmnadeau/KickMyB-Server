package org.kickmyb.server;

import com.google.gson.*;
import org.joda.time.DateTime;
import org.kickmyb.CustomGson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;

// le but est de forcer un seul format compatible avec Java de Android par défaut
// https://github.com/google/gson/blob/master/gson/src/main/java/com/google/gson/internal/bind/DateTypeAdapter.java


@Configuration
@ConditionalOnClass(Gson.class)
public class ConfigJSON {

    @Bean
    public Gson gson() {
        String dateFormat = "yyyy-MM-dd HH:mm:ss Z";

        GsonBuilder builder = new GsonBuilder();
        builder.enableComplexMapKeySerialization();
        builder.setDateFormat(dateFormat);

        builder.registerTypeAdapter(byte[].class, new CustomGson.ByteArraySerialiser());
        builder.setPrettyPrinting();
        return builder.create();
    }

}

package demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.IOException;

public class controller {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();


    private static ObjectMapper getDefaultObjectMapper() {

        ObjectMapper defaultObjectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        //Update defaultObjectMapper
        //   ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {

        return objectMapper.treeToValue(node, clazz);

    }

    public static JsonNode toJson(Object a) {
        return objectMapper.valueToTree(a);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateString(node, false);
    }

    public static String prettyPrint(JsonNode node) throws JsonProcessingException {

        return generateString(node, true);
    }

    private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {

        ObjectWriter objectWriter = objectMapper.writer();
        if (pretty)
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);

        return objectWriter.writeValueAsString(node);
    }
}


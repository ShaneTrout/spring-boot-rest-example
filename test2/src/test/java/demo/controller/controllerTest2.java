package demo.controller;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class controllerTest2 {
    private String simpleTestCaseJsonSource = "{ \"title\": \"NHL Parser\" }";

    @org.junit.jupiter.api.Test
    void parse() throws IOException {

        JsonNode node = controller.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "NHL Parser");

    }
}
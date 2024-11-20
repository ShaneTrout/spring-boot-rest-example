package demo.controller.nhlobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class config {
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
}

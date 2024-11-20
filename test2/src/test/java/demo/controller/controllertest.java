package demo.controller;
import java.time.LocalDate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectWriter;
import demo.controller.nhlobject.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.YearMonth;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


class controllertest {

    private String simpleTestCaseJsonSource = "{\n" +
            "  \"title\": \"NHL Parser\",\n" +
            "  \"author\": \"sweaterNumber\"\n" +
            "}";

    private String bobbyBrink = "{\n" +
            "  \"id\": 8481599 ,\n" +
            "  \"firstName\": \"Bobby\"\n" +
            "}";

    private String rosterTest = "{\n " +
            " \"id\": 8481553,\n  " +
            " \"fullNames\": [\n" +
            "    {\n" +
            "      \"last\": \"Brink\",\n" +
            "      \"first\": \"Bobby\",\n " +
            "     \"active\": true\n " +
            "   },\n" +
            "    {\n " +
            "     \"last\": \"Courturier\",\n " +
            "     \"first\": \"Sean\",\n  " +
            "    \"active\": false\n  " +
            "  }\n " +
            " ]\n" +
            "}";

    private String nhlData = new NHL2().getJsonResponse();

    controllertest() throws IOException {
    }

    @Test
    void parse() throws IOException {

        JsonNode node = controller.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "NHL Parser");

    }

    @Test
    void fromJson() throws IOException {

        JsonNode node = controller.parse(simpleTestCaseJsonSource);
        nhlTestJsonObject response = controller.fromJson(node, nhlTestJsonObject.class);

        assertEquals(response.getTitle(), "NHL Parser");
    }

    @Test
    void toJson() {
        nhlTestJsonObject response = new nhlTestJsonObject();
        response.setTitle("testing123");
        JsonNode node = controller.toJson(response);

        assertEquals(node.get("title").asText(), "testing123");
    }

    @Test
    void stringify() throws JsonProcessingException {
        nhlTestJsonObject response = new nhlTestJsonObject();
        response.setTitle("testing123");

        JsonNode node = controller.toJson(response);

        assertEquals(node.get("title").asText(), "testing123");
        //use for testing to pring ^remove to use
        //System.out.println(controller.stringify(node));
        //System.out.println(controller.prettyPrint(node));

    }

    @Test
    void brinkTest1() throws IOException {

        JsonNode node = controller.parse(bobbyBrink);
        BrinkObject response = controller.fromJson(node, BrinkObject.class);

        assertEquals(8481599, response.getId());
    }

    @Test
    void rosterTest() throws IOException {
        JsonNode node = controller.parse(rosterTest);
        TeamsObject response = controller.fromJson(node, TeamsObject.class);

        System.out.println("Full name: " + response.getId());
        for (FullNamesObject teams : response.getFullNames()) {
            System.out.println("Lname: " + teams.getLast());
            System.out.println("Fname: " + teams.getFirst());
            System.out.println("Act?: " + teams.isActive());

        }
    }

    @Test
    void scheduleTest() throws IOException {
        JsonNode node = controller.parse(nhlData);
        ScheduleObject response = controller.fromJson(node, ScheduleObject.class);

        System.out.println("This Month " + response.getCurrentMonth());
        for (GamesObject games : response.getGames()) {
            System.out.println( "Date: " + games.getGameDate());
            System.out.println("Venue " + games.getVenue().getDefaultVenue());
            System.out.println("Home Team:" + games.getHomeTeam().getAbbrev() + "Score: " + games.getHomeTeam().getScore());
            System.out.println("Away Team:" + games.getAwayTeam().getAbbrev() + "Score: " + games.getAwayTeam().getScore());
        }

        }



    }



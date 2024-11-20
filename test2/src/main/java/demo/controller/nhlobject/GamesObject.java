package demo.controller.nhlobject;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.YearMonth;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GamesObject {
    private VenueObject venue;
    private AwayTeam awayTeam;
    private HomeTeam homeTeam;
    private LocalDate gameDate;

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public VenueObject getVenue() {
        return venue;
    }

    public void setVenue(VenueObject venue) {
        this.venue = venue;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }


}

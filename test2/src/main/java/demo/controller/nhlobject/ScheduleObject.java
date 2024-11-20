package demo.controller.nhlobject;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.YearMonth;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ScheduleObject {

    @JsonFormat(pattern = "yyyy-MM") // Define the expected format explicitly
    private YearMonth currentMonth;
    private List<GamesObject> games;

    public YearMonth getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(YearMonth currentMonth) {
        this.currentMonth = currentMonth;
    }

    public List<GamesObject> getGames() {
        return games;
    }

    public void setGames(List<GamesObject> games) {
        this.games = games;
    }
}

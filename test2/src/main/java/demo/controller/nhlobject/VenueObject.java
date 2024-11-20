package demo.controller.nhlobject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VenueObject {

    @JsonProperty("default")
    private String defaultVenue;

    public String getDefaultVenue() {
        return defaultVenue;
    }

    public void setDefaultVenue(String defaultVenue) {
        this.defaultVenue = defaultVenue;
    }
}

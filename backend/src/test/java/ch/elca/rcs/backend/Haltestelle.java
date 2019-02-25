package ch.elca.rcs.backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.web.JsonPath;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Haltestelle {

    private String name;

    @JsonProperty("Dst-Nr.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

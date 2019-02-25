package ch.elca.rcs.backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.web.JsonPath;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Haltestelle {

    @JsonProperty("Dst-Nr.")
    private String name;
}

package ch.elca.rcs.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.web.JsonPath;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Haltestelle {

    @JsonProperty("Dst-Nr.")
    private String name;

    @JsonProperty("Dst-Nr.")
    private String ort;

    @JsonProperty("Dst-Nr.")
    private BigDecimal hoehe;

    @JsonProperty("Dst-Nr.")
    private String gemeinde;

    @JsonProperty("Dst-Nr.")
    private String transportunternehmung;

    @JsonProperty("Dst-Nr.")
    private BigDecimal koordOst;

    @JsonProperty("Dst-Nr.")
    private BigDecimal koordNord;
}

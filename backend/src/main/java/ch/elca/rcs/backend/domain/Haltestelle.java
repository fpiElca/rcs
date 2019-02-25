package ch.elca.rcs.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.web.JsonPath;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Haltestelle {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("Dst-Bezeichnung-offiziell")
    private String name;

    @JsonProperty("Ort")
    private String ort;

    @JsonProperty("KOORDZ")
    private BigDecimal hoehe;

    @JsonProperty("Gde-Name")
    private String gemeinde;

    @JsonProperty("GO-Abk")
    private String transportunternehmung;

    @JsonProperty("KOORDE")
    private BigDecimal koordOst;

    @JsonProperty("KOORDN")
    private BigDecimal koordNord;
}

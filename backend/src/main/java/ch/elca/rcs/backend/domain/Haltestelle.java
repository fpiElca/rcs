package ch.elca.rcs.backend.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Haltestelle {

    @Id
    @GeneratedValue
    private Long id;

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String ort;

    @CsvBindByPosition(position = 2)
    private BigDecimal hoehe;

    @CsvBindByPosition(position = 3)
    private String gemeinde;

    @CsvBindByPosition(position = 4)
    private String transportunternehmung;

    @CsvBindByPosition(position = 5)
    private BigDecimal koordOst;

    @CsvBindByPosition(position = 6)
    private BigDecimal koordNord;
}

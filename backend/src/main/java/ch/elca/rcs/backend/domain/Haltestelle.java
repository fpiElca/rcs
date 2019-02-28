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

    @CsvBindByPosition(position = 2)
    private String name;

    @CsvBindByPosition(position = 7)
    private String ort;

    //@CsvBindByPosition(position = 2)
    private BigDecimal hoehe;

    @CsvBindByPosition(position = 9)
    private String gemeinde;

    @CsvBindByPosition(position = 6)
    private String transportunternehmung;

    @CsvBindByPosition(position = 16)
    private String koordOst;

    @CsvBindByPosition(position = 17)
    private String koordNord;
}

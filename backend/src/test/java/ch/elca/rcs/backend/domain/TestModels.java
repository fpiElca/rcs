package ch.elca.rcs.backend.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.toList;
import static java.math.BigDecimal.valueOf;

import java.util.List;
import java.util.stream.IntStream;

public class TestModels {

    public List<Haltestelle> createHaltestellen(int howMany) {
        checkArgument(howMany > 0, "howMany must by > 0");

        return IntStream.rangeClosed(1, howMany).mapToObj(i -> {
            Haltestelle result = new Haltestelle();
            result.setName("Haltestelle " + i);
            result.setGemeinde("Gemeinde " + i);
            result.setOrt("Ort " + i);
            result.setHoehe(valueOf(300 + 10 * i));
            result.setKoordNord(valueOf(1000 + i).toString());
            result.setKoordOst(valueOf(5000 + i).toString());
            result.setTransportunternehmung("TU " + i);
            return result;
        }).collect(toList());
    }

}

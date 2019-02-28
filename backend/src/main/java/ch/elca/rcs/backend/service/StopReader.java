package ch.elca.rcs.backend.service;

import ch.elca.rcs.backend.domain.Haltestelle;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class StopReader {

    public static List<Haltestelle> parseStops(InputStream inputstream) throws Exception {
        List<Haltestelle> haltestelleList;
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Haltestelle.class);

        try (Reader reader = new StringReader(new String(inputstream.readAllBytes(), "UTF-8"))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Haltestelle.class)
                .withSkipLines(1) // To skip header
                .withQuoteChar('"')
                .withSeparator(';')
                .withEscapeChar('\0')
                .withMappingStrategy(mappingStrategy).build();

            haltestelleList = csvToBean.parse();
        }
        return haltestelleList;
    }
}

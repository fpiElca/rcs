package ch.elca.rcs.backend.service;

import ch.elca.rcs.backend.domain.Haltestelle;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class StopReader {

    private List<Haltestelle> parseFile(byte[] importData) throws Exception {
        List<Haltestelle> haltestelleList;
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Haltestelle.class);

        try (Reader reader = new StringReader(new String(importData, "UTF-8"))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Haltestelle.class)
                .withQuoteChar('"')
                .withSeparator(';')
                .withEscapeChar('\0')
                .withMappingStrategy(mappingStrategy).build();

            haltestelleList = csvToBean.parse();
        }
        return haltestelleList;
    }
}

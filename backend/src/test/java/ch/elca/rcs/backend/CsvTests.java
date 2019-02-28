package ch.elca.rcs.backend;

import ch.elca.rcs.backend.domain.Haltestelle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvTests {

    @Test
    @Ignore
    public void test() throws IOException {

        CsvSchema schema = CsvSchema.builder()
                .setUseHeader(true)
                .setColumnSeparator(';')
                .build();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File file = new ClassPathResource("didok.csv").getFile();
        MappingIterator<Haltestelle> readValues = csvMapper.reader(Haltestelle.class).with(schema).readValues(file);

        List<Haltestelle> items = readValues.readAll();
        Assert.assertTrue(items.size() > 10);
    }
}

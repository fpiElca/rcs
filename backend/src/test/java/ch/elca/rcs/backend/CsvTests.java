package ch.elca.rcs.backend;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Assert;
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
    public void test() throws IOException {

        CsvSchema schema = CsvSchema.builder()
                .setUseHeader(true)
                .setColumnSeparator(';')
                .build();

        CsvSchema bootstarpSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        File file = new ClassPathResource("didok.csv").getFile();
        MappingIterator<Haltestelle> readValues = csvMapper.reader(Haltestelle.class).with(schema).readValues(file);

        List<Haltestelle> items = readValues.readAll();
        int i = 0;
        Assert.assertTrue(items.size() > 10);
    }
}

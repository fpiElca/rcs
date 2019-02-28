package ch.elca.rcs.backend.service;

import ch.elca.rcs.backend.domain.Haltestelle;
import ch.elca.rcs.backend.repository.HaltestelleRepository;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class initializes some sample Haltestelle so that we can play a bit with the application
 * while some content in it.
 */
@Component
@Slf4j
public class SampleHaltestelleInitializer implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleHaltestelleInitializer.class);

    private static final String IMPORT_FILE_EXTENSION_CSV = "csv";

    private static final Set<String> POSSIBLE_CSV_MIME_TYPES = new HashSet<String>(Arrays.asList(
        "application/csv",
        "application/x-csv",
        "text/csv",
        "text/comma-separated-values",
        "text/x-comma-separated-values",
        "text/tab-separated-values",
        "application/vnd.ms-excel",
        "text/x-csv",
        "text/plain"));

    @Value("${stops.sample.data}")
    private String stopSampleFilename;

    @Autowired
    private HaltestelleRepository haltestelleRepository;

    @Override
    public void run(ApplicationArguments args) {
        LOGGER.info("Starting DB initialization of some Stops");
        try {
            Resource resource = new ClassPathResource(stopSampleFilename);

            InputStream stopsInputStream = resource.getInputStream();

            Tika tika = new Tika();
            String mimeType = tika.detect(stopsInputStream);
            String fileExtension = Files.getFileExtension(resource.getFilename());

            log.info("File read with mime type: {}", mimeType);

            if (POSSIBLE_CSV_MIME_TYPES.contains(mimeType) && IMPORT_FILE_EXTENSION_CSV.equals(fileExtension)) {
                try {
                    List<Haltestelle> sampleData = StopReader.parseStops(stopsInputStream);
                    haltestelleRepository.saveAll(sampleData);

                } catch (Exception ex) {
                    log.error("Exception while parsing and saving: {}", ex);
                }
            } else {
                log.error("File format: {} or extension: {} not correct: {}", mimeType, fileExtension);
            }
        } catch (Exception ex) {
            log.error("Exception while importing file: {}", ex);
        }
        log.info("-- End stops initialization --");
    }
}

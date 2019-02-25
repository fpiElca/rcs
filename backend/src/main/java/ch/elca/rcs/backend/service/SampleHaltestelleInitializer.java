package ch.elca.rcs.backend.service;

import ch.elca.rcs.backend.domain.Haltestelle;
import ch.elca.rcs.backend.repository.HaltestelleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * This class initializes some sample Haltestelle so that we can play a bit with the application
 * while some content in it.
 */
@Component
public class SampleHaltestelleInitializer implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleHaltestelleInitializer.class);

    @Autowired
    private HaltestelleRepository haltestelleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Initializing some Haltestelle");

        List<Haltestelle> sampleData = new LinkedList<>();

        Haltestelle haltestelle = new Haltestelle();
        sampleData.add(haltestelle);

        haltestelle = new Haltestelle();
        sampleData.add(haltestelle);

        haltestelle = new Haltestelle();
        sampleData.add(haltestelle);

        haltestelleRepository.saveAll(sampleData);
    }
}

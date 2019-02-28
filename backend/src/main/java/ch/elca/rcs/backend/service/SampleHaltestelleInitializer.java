package ch.elca.rcs.backend.service;

import ch.elca.rcs.backend.domain.Haltestelle;
import ch.elca.rcs.backend.repository.HaltestelleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
        haltestelle.setName("First Haltestelle");
        haltestelle.setGemeinde("Bern");
        haltestelle.setHoehe(BigDecimal.valueOf(4));
        haltestelle.setOrt("Bern");
        haltestelle.setTransportunternehmung("SBB");
        haltestelle.setKoordNord(BigDecimal.valueOf(12));
        haltestelle.setKoordOst(BigDecimal.valueOf(12));
        sampleData.add(haltestelle);

        haltestelle = new Haltestelle();
        haltestelle.setName("Second Haltestelle");
        haltestelle.setGemeinde("Neuchatel");
        haltestelle.setHoehe(BigDecimal.valueOf(10));
        haltestelle.setOrt("Neuchatel");
        haltestelle.setTransportunternehmung("SBB");
        haltestelle.setKoordNord(BigDecimal.valueOf(21));
        haltestelle.setKoordOst(BigDecimal.valueOf(21));
        sampleData.add(haltestelle);

        haltestelle = new Haltestelle();
        haltestelle.setName("Third Haltestelle");
        haltestelle.setGemeinde("Genève");
        haltestelle.setHoehe(BigDecimal.valueOf(15));
        haltestelle.setOrt("Genève");
        haltestelle.setTransportunternehmung("SBB");
        haltestelle.setKoordNord(BigDecimal.valueOf(14));
        haltestelle.setKoordOst(BigDecimal.valueOf(14));
        sampleData.add(haltestelle);

        haltestelleRepository.saveAll(sampleData);
    }
}

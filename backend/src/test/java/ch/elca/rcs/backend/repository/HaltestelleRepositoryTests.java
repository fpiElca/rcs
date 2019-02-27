package ch.elca.rcs.backend.repository;

import ch.elca.rcs.backend.domain.Haltestelle;
import ch.elca.rcs.backend.domain.TestModels;
import com.google.common.base.Preconditions;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HaltestelleRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HaltestelleRepository haltestelleRepository;

    private TestModels testModels = new TestModels();

    @Test
    public void save_haltestelleGiven_persisted() {
        Haltestelle haltestelle = testModels.createHaltestellen(1).get(0);
        haltestelle.setId(null);

        // act
        haltestelleRepository.save(haltestelle);

        // assert
        assertThat(haltestelle.getId()).isNotNull();
    }

    @Test
    public void delete_haltestelleExists_deleted() {
        Haltestelle haltestelle = testModels.createHaltestellen(1).get(0);
        entityManager.persist(haltestelle);
        Preconditions.checkState(entityManager.find(Haltestelle.class, haltestelle.getId()) != null);

        // act
        haltestelleRepository.delete(haltestelle);

        // assert
        assertThat(entityManager.find(Haltestelle.class, haltestelle.getId())).isNull();

    }
}
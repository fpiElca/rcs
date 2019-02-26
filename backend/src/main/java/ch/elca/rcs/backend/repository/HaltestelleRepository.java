package ch.elca.rcs.backend.repository;

import ch.elca.rcs.backend.domain.Haltestelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "haltestellen", path = "haltestellen")
public interface HaltestelleRepository extends JpaRepository<Haltestelle, Long> {

}

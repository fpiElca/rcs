package ch.elca.rcs.backend.repository;

import ch.elca.rcs.backend.domain.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DummyRepository extends JpaRepository<DummyEntity, Long> {

}

package ch.elca.rcs.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DummyEntity {

    private @Id @GeneratedValue Long id;
    private String description;
}

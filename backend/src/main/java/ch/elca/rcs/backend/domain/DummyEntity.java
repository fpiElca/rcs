package ch.elca.rcs.backend.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class DummyEntity {

    @Id @GeneratedValue
    @ApiModelProperty(notes = "This is just an ID", required = true, allowableValues = "0, 1, 2")
    private Long id;

    @ApiModelProperty(notes = "The description of this instance")
    private String description;
}

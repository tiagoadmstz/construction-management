package io.github.tiagoadmstz.cm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "private_constructions")
@SequenceGenerator(name = "private_constructions_seq", sequenceName = "private_constructions_seq", allocationSize = 1)
public class PrivateConstruction implements Serializable {

    private static final long serialVersionUID = 7211341335328656946L;
    @Id
    @Column(name = "number")
    @GeneratedValue(generator = "private_constructions_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated
    @Column(name = "zone", length = 5)
    private Zone zone;
    @Column(name = "total_area", length = 50)
    private String totalArea;
    @Embedded
    private Construction construction;

}

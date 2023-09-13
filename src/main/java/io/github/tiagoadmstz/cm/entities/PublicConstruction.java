package io.github.tiagoadmstz.cm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "public_constructions")
@SequenceGenerator(name = "public_constructions_seq", sequenceName = "public_constructions_seq", allocationSize = 1)
public class PublicConstruction implements Serializable {

    private static final long serialVersionUID = -4305941529240076393L;
    @Id
    @Column(name = "number")
    @GeneratedValue(generator = "public_constructions_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "initial_date", columnDefinition = "date")
    private LocalDate initialDate;
    @Column(name = "end_date", columnDefinition = "date")
    private LocalDate endDate;
    @Embedded
    private Construction construction;

}

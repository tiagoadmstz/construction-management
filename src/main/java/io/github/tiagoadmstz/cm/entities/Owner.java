package io.github.tiagoadmstz.cm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "owners")
@SequenceGenerator(name = "owners_seq", sequenceName = "owners_seq", allocationSize = 1)
public class Owner implements Serializable {

    private static final long serialVersionUID = -3526405237893880994L;
    @Id
    @Column(name = "code")
    @GeneratedValue(generator = "owners_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "name", length = 50)
    private String name;

}

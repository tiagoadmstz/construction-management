package io.github.tiagoadmstz.cm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Embeddable
public class Construction implements Serializable {

    private static final long serialVersionUID = -9220337366647147885L;
    @Enumerated
    @Column(name = "type", length = 7)
    private ConstructionType constructionType;
    @Column(name = "register_date", columnDefinition = "timestamp")
    private LocalDateTime registerDate;
    @Column(name = "description")
    private String description;
    @OneToMany
    private List<Owner> owners;

}

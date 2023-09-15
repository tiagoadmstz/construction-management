package io.github.tiagoadmstz.cm.entities;

import io.github.tiagoadmstz.cm.dtos.OwnerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
@Embeddable
public class Construction implements Serializable {

    private static final long serialVersionUID = -9220337366647147885L;
    @Enumerated
    @Column(name = "type", length = 7)
    private ConstructionType constructionType;
    @Column(name = "register_date", columnDefinition = "timestamp")
    private LocalDateTime registerDate = LocalDateTime.now();
    @Column(name = "description")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Owner> owners;

    public void setOwnersByDto(List<OwnerDto> ownerDtoList) {
        if (Objects.nonNull(ownerDtoList)) {
            owners = ownerDtoList.stream()
                    .map(Owner::new)
                    .toList();
        }
    }
}

package io.github.tiagoadmstz.cm.entities;

import io.github.tiagoadmstz.cm.dtos.PrivateConstructionDto;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "total_area")
    private Long totalArea;
    @Embedded
    private Construction construction = new Construction();

    public PrivateConstruction(PrivateConstructionDto privateConstructionDto) {
        id = privateConstructionDto.getId();
        zone = Zone.parse(privateConstructionDto.getZone());
        totalArea = privateConstructionDto.getTotalArea();
        construction.setConstructionType(ConstructionType.PRIVATE);
        construction.setDescription(privateConstructionDto.getDescription());
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (Objects.nonNull(privateConstructionDto.getRegisterDate())) {
            construction.setRegisterDate(LocalDateTime.of(
                    LocalDate.parse(privateConstructionDto.getRegisterDate(), dateTimeFormatter),
                    LocalTime.now()
            ));
        }
        construction.setOwnersByDto(privateConstructionDto.getOwners());
    }
}

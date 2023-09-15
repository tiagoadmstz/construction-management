package io.github.tiagoadmstz.cm.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.cm.entities.Construction;
import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicConstructionDto implements Serializable {

    private static final long serialVersionUID = 4416906064875797991L;
    @JsonProperty("número")
    private final Long id;
    @JsonProperty("data de cadastro")
    private final String registerDate;
    @JsonProperty("descrição")
    private final String description;
    @JsonProperty("data de início")
    private final String initialDate;
    @JsonProperty("data de fim")
    private final String endDate;
    @JsonProperty("responsáveis")
    private final List<OwnerDto> owners;

    public PublicConstructionDto(PublicConstruction publicConstruction) {
        id = publicConstruction.getId();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        initialDate = publicConstruction.getInitialDate().format(dateTimeFormatter);
        endDate = publicConstruction.getEndDate().format(dateTimeFormatter);
        final Construction construction = publicConstruction.getConstruction();
        registerDate = dateTimeFormatter.format(construction.getRegisterDate());
        description = construction.getDescription();
        owners = construction.getOwners().stream().map(OwnerDto::new).toList();
    }

}

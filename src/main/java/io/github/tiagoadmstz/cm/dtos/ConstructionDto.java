package io.github.tiagoadmstz.cm.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.cm.entities.Construction;
import io.github.tiagoadmstz.cm.entities.ConstructionType;
import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConstructionDto implements Serializable {

    private static final long serialVersionUID = -6777513161716554752L;
    @JsonProperty("número")
    private Long id;
    @JsonProperty("tipo de obra")
    private String type;
    @JsonProperty("data de cadastro")
    private String registerDate;
    @JsonProperty("descrição")
    private String description;
    @JsonProperty("data de início")
    private String initialDate;
    @JsonProperty("data de fim")
    private String endDate;
    @JsonProperty("zona")
    private String zone;
    @JsonProperty("área total")
    private Long totalArea;
    @JsonProperty("responsáveis")
    private List<OwnerDto> owners;

    public ConstructionDto(PublicConstruction publicConstruction) {
        id = publicConstruction.getId();
        type = ConstructionType.PUBLIC.getValue();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        initialDate = publicConstruction.getInitialDate().format(dateTimeFormatter);
        endDate = publicConstruction.getEndDate().format(dateTimeFormatter);
        final Construction construction = publicConstruction.getConstruction();
        registerDate = dateTimeFormatter.format(construction.getRegisterDate());
        description = construction.getDescription();
        owners = construction.getOwners().stream().map(OwnerDto::new).toList();
    }

    public ConstructionDto(PrivateConstruction privateConstruction) {
        id = privateConstruction.getId();
        type = ConstructionType.PRIVATE.getValue();
        totalArea = privateConstruction.getTotalArea();
        zone = privateConstruction.getZone().getValue();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        final Construction construction = privateConstruction.getConstruction();
        registerDate = dateTimeFormatter.format(construction.getRegisterDate());
        description = construction.getDescription();
        owners = construction.getOwners().stream().map(OwnerDto::new).toList();
    }
}

package io.github.tiagoadmstz.cm.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.cm.entities.Construction;
import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrivateConstructionDto implements Serializable {

    private static final long serialVersionUID = 8505362069839169936L;
    @JsonProperty("número")
    private Long id;
    @JsonProperty("data de cadastro")
    private String registerDate;
    @JsonProperty("descrição")
    private String description;
    @JsonProperty("zona")
    private String zone;
    @JsonProperty("área total")
    private Long totalArea;
    @JsonProperty("responsáveis")
    private List<OwnerDto> owners;

    public PrivateConstructionDto(PrivateConstruction privateConstruction) {
        id = privateConstruction.getId();
        totalArea = privateConstruction.getTotalArea();
        zone = privateConstruction.getZone().getValue();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        final Construction construction = privateConstruction.getConstruction();
        registerDate = dateTimeFormatter.format(construction.getRegisterDate());
        description = construction.getDescription();
        owners = construction.getOwners().stream().map(OwnerDto::new).toList();
    }
}

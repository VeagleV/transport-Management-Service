package com.crm.transport.core.dto;

import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность транспорта - форма запроса(request)")
public class TransportRequest {

    @JsonProperty("warehouse_id")
    @Schema(description = "Идентификатор склада")
    @PositiveOrZero
    private Integer warehouseId;

    @Schema(description = "Статус", allowableValues = {"AVAILABLE", "IN_TRANSIT", "MAINTENANCE", "OUT_OF_SERVICE"})
    @JsonProperty("status")
    private Status status;

    @Schema(description = "Тип", allowableValues = {"AVIA", "ROAD", "TRAIN"})
    @JsonProperty("type")
    private Type type;

    @Schema(description = "Вместимость", example = "1000")
    @JsonProperty("capacity")
    @Positive
    private Integer capacity;

    @Schema(description = "Скорость", example = "90")
    @JsonProperty("speed")
    @Positive
    private Integer speed;

    @Schema(description = "Стоимость за километр", example = "100.5")
    @JsonProperty("cost")
    @Positive
    private Double cost;
}

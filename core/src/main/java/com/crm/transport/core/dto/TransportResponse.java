package com.crm.transport.core.dto;

import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность транспорта - форма ответа(response)")
public class TransportResponse {

    @Schema(description = "Идентификатор транспорта")
    @JsonProperty("transport_id")
    @Min(0)
    private Integer transportId;

    @Schema(description = "Идентификатор склада")
    @JsonProperty("warehouse_id")
    @Min(0)
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

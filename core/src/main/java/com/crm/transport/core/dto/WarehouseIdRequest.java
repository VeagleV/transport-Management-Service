package com.crm.transport.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Получаем список таких ID, для нахождения всего нужного транспорта")
public class WarehouseIdRequest {
    @JsonProperty("warehouse_id")
    @Schema(description = "Идентификатор склада")
    private Integer warehouseId;
}

package com.crm.transport.core.controllers;

import com.crm.transport.core.dto.TransportRequest;
import com.crm.transport.core.dto.TransportResponse;
import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import com.crm.transport.core.services.TransportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Transport Controller",
        description = "Контроллер для управления транспортом"
)
@RestController
@RequestMapping("/transports")
public class TransportController {

    private final TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("/")
    @Operation(summary = "Получение всех транспортов", description = "Позволяет получить все транспорты")
    public ResponseEntity<List<TransportResponse>> getAllTransports() {
        List<TransportResponse> transports = transportService.getAllTransports();
        if (transports.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @GetMapping("/{transportId}")
    @Operation(summary = "Получение транспорта", description = "Позволяет получить транспорт по id")
    public ResponseEntity<TransportResponse> getTransportById(
            @PathVariable @Min(0) @Parameter(description = "Идентификатор транспорта", required = true) Integer transportId
    ) {
        TransportResponse transport = transportService.getTransportById(transportId);
        if (transport == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transport, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Получение транспортов по статусу", description = "Позволяет получить транспорты по значеню status")
    public ResponseEntity<List<TransportResponse>> getTransportByStatus(
            @PathVariable @Parameter(description = "Значение статуса", required = true) Status status
    ) {
        List<TransportResponse> transports = transportService.getAllTransportsByStatus(status);
        if (transports.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    @Operation(summary = "Получение транспортов по типу", description = "Позволяет получить транспорт по значению type")
    public ResponseEntity<List<TransportResponse>> getTransportByType(
            @PathVariable @Parameter(description = "Значение типа транспорта", required = true) Type type
    ) {
        List<TransportResponse> transports = transportService.getAllTransportsByType(type);
        if (transports == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{warehouseId}")
    @Operation(summary = "Получение транспортов склада", description = "Позволяет получить транспорт у конкретного склада")
    public ResponseEntity<List<TransportResponse>> getTransportByWarehouseId(
            @PathVariable @Min(0) @Parameter(description = "Идентификатор склада", required = true) Integer warehouseId
    ) {
        List<TransportResponse> transports = transportService.getAllTransportsByWarehouseId(warehouseId);
        if (transports.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Добавление транспорта", description = "Позволяет создать транспорт")
    public ResponseEntity<TransportResponse> createTransport(
            @RequestBody TransportRequest transportRequest
    ) {
        TransportResponse response = transportService.createTransport(transportRequest);
        if (response == null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{transportId}")
    @Operation(summary = "Изменение транспорта", description = "Позволяет изменить информацию о транспорте")
    public ResponseEntity<TransportResponse> updateTransport(
            @PathVariable @Min(0) @Parameter(description = "Идентификатор транспорта", required = true) Integer transportId,
            @RequestBody TransportRequest transportRequest
    ) {
        TransportResponse response = transportService.updateTransport(transportId, transportRequest);
        if(response == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{transportId}")
    @Operation(summary = "Удаление транспорта", description = "Позволяет удалить информацию о транспорте")
    public ResponseEntity<TransportResponse> deleteTransport(
            @PathVariable @Min(0) @Parameter(description = "Идентификатор транспорта", required = true) Integer transportId
    ) {
        TransportResponse transport = transportService.deleteTransport(transportId);
        return transport != null
                ? new ResponseEntity<>(transport, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

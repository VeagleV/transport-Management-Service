package com.crm.transport.core.services;

import com.crm.transport.core.dto.TransportRequest;
import com.crm.transport.core.dto.TransportResponse;
import com.crm.transport.core.entities.Transport;
import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import com.crm.transport.core.mappers.TransportMappers;
import com.crm.transport.core.repositories.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    private final TransportRepository transportRepository;
    @Autowired
    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<TransportResponse> getAllTransports() {
        List<Transport> transports = transportRepository.findAll();
        if(transports.isEmpty()) return null;
        return transports.stream()
                .map(TransportMappers::createTransportResponse)
                .toList();
    }

    public TransportResponse getTransportById(Integer id) {
        Optional<Transport> transport = transportRepository.findById(id);
        if (transport.isEmpty()) return null;
        return TransportMappers.createTransportResponse(transport.get());
    }

    public TransportResponse createTransport(TransportRequest transportRequest) {
        Transport transport = TransportMappers.createTransport(transportRequest);
        return TransportMappers.createTransportResponse(transportRepository.save(transport));
    }

    public TransportResponse deleteTransport(Integer id) {
        Transport transport = transportRepository.findById(id).orElse(null);
        if (transport == null) return null;
        transportRepository.delete(transport);
        return TransportMappers.createTransportResponse(transport);
    }

    public TransportResponse updateTransport(Integer id, TransportRequest transportRequest) {
        Transport transport = transportRepository.findById(id).orElse(null);
        if (transport == null) return null;
        Transport updatedTransport = TransportMappers.updateTransport(transport, transportRequest);
        return TransportMappers.createTransportResponse(updatedTransport);
    }

    public List<TransportResponse> getAllTransportsByWarehouseId(Integer warehouseId) {
        List<Transport> transports = transportRepository.findByWarehouseId(warehouseId);
        return transports.stream().map(TransportMappers::createTransportResponse).toList();
    }

    public List<TransportResponse> getAllTransportsByType(Type type) {
        List<Transport> transports = transportRepository.findAllByType(type);
        if (transports.isEmpty()) return null;
        return transports.stream()
                .map(TransportMappers::createTransportResponse)
                .toList();
    }

    public List<TransportResponse> getAllTransportsByStatus(Status status) {
        List<Transport> transports = transportRepository.findAllByStatus(status);
        if (transports.isEmpty()) return null;
        return transports.stream()
                .map(TransportMappers::createTransportResponse)
                .toList();
    }

}


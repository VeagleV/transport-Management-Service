package com.crm.transport.core.mappers;

import com.crm.transport.core.dto.TransportRequest;
import com.crm.transport.core.dto.TransportResponse;
import com.crm.transport.core.entities.Transport;

public class TransportMappers {
    public static TransportResponse createTransportResponse(Transport transport) {
        TransportResponse response = new TransportResponse();
        response.setTransportId(transport.getId());
        response.setWarehouseId(transport.getWarehouseId());
        response.setType(transport.getType());
        response.setStatus(transport.getStatus());
        response.setCost(transport.getCost());
        response.setCapacity(transport.getCapacity());
        response.setSpeed(transport.getSpeed());
        return response;
    }

    public static Transport createTransport(TransportRequest transportRequest) {
        Transport transport = new Transport();
        return getTransport(transport, transportRequest);
    }

    public static Transport updateTransport(Transport existingTransport, TransportRequest transportRequest) {
        return getTransport(existingTransport, transportRequest);
    }

    private static Transport getTransport(Transport existingTransport, TransportRequest transportRequest) {
        existingTransport.setWarehouseId(transportRequest.getWarehouseId());
        existingTransport.setType(transportRequest.getType());
        existingTransport.setStatus(transportRequest.getStatus());
        existingTransport.setCost(transportRequest.getCost());
        existingTransport.setCapacity(transportRequest.getCapacity());
        existingTransport.setSpeed(transportRequest.getSpeed());
        return existingTransport;
    }
}

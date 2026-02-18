package com.crm.transport.core.repositories;

import com.crm.transport.core.entities.Transport;
import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransitRepository extends JpaRepository<Transport, Integer> {
    Transport findById(int id);
    Optional<Transport> findByWarehouseId(int warehouseId);
    Optional<Transport> findAllByType(Type type);
    Optional<Transport> findAllByStatus(Status status);
}

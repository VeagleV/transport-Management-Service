package com.crm.transport.core.repositories;

import com.crm.transport.core.entities.Transport;
import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransitRepository extends JpaRepository<Transport, Integer> {
    List<Transport> findByWarehouseId(int warehouseId);
    List<Transport> findAllByType(Type type);
    List<Transport> findAllByStatus(Status status);
}

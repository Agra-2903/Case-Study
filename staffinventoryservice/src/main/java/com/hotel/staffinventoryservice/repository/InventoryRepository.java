package com.hotel.staffinventoryservice.repository;

import com.hotel.staffinventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}

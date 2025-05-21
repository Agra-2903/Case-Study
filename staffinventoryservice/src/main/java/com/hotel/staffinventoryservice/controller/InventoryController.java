package com.hotel.staffinventoryservice.controller;

import com.hotel.staffinventoryservice.model.Inventory;
import com.hotel.staffinventoryservice.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping("/add")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @GetMapping("/{id}")
    public Inventory getInventory(@PathVariable Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory item not found"));
    }

    @GetMapping("/all")
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryDetails) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory item not found"));
        inventory.setItemName(inventoryDetails.getItemName());
        inventory.setQuantity(inventoryDetails.getQuantity());
        inventory.setPrice(inventoryDetails.getPrice());
        return inventoryRepository.save(inventory);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
        return "Inventory item deleted successfully";
    }
}

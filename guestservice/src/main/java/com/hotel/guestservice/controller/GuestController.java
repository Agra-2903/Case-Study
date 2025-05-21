package com.hotel.guestservice.controller;

import com.hotel.guestservice.model.Guest;
import com.hotel.guestservice.repository.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id) {
        return guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
    }

    @GetMapping("/all")
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
        guest.setName(guestDetails.getName());
        guest.setPhoneNumber(guestDetails.getPhoneNumber());
        guest.setEmail(guestDetails.getEmail());
        guest.setAddress(guestDetails.getAddress());
        return guestRepository.save(guest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGuest(@PathVariable Long id) {
        guestRepository.deleteById(id);
        return "Guest deleted successfully";
    }
}

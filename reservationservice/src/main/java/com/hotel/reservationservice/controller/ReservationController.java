package com.hotel.reservationservice.controller;

import com.hotel.reservationservice.model.Reservation;
import com.hotel.reservationservice.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/add")
    public Reservation makeReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @GetMapping("/guest/{guestId}")
    public List<Reservation> getReservationsByGuest(@PathVariable Long guestId) {
        return reservationRepository.findByGuestId(guestId);
    }

    @GetMapping("/room/{roomId}")
    public List<Reservation> getReservationsByRoom(@PathVariable Long roomId) {
        return reservationRepository.findByRoomId(roomId);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setGuestId(reservationDetails.getGuestId());
        reservation.setRoomId(reservationDetails.getRoomId());
        reservation.setNumberOfChildren(reservationDetails.getNumberOfChildren());
        reservation.setNumberOfAdults(reservationDetails.getNumberOfAdults());
        reservation.setCheckInDate(reservationDetails.getCheckInDate());
        reservation.setCheckOutDate(reservationDetails.getCheckOutDate());
        reservation.setNumberOfNights(reservationDetails.getNumberOfNights());
        reservation.setStatus(reservationDetails.getStatus());

        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public String cancelReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return "Reservation cancelled successfully";
    }
}

package com.hotel.staffinventoryservice.controller;

import com.hotel.staffinventoryservice.model.Staff;
import com.hotel.staffinventoryservice.repository.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @PostMapping("/add")
    public Staff addStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
    }

    @GetMapping("/all")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staffDetails) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        staff.setName(staffDetails.getName());
        staff.setOccupation(staffDetails.getOccupation());
        staff.setSalary(staffDetails.getSalary());
        staff.setEmail(staffDetails.getEmail());
        staff.setAge(staffDetails.getAge());
        return staffRepository.save(staff);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        staffRepository.deleteById(id);
        return "Staff deleted successfully";
    }
}

package com.abby.hms.service;

import com.abby.hms.model.Staff;
import com.abby.hms.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(Long id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.orElse(null);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff updateStaff(Long id, Staff staffDetails) {
        Optional<Staff> staff = staffRepository.findById(id);

        if (staff.isPresent()) {
            Staff existingStaff = staff.get();
            existingStaff.setName(staffDetails.getName());
            existingStaff.setRole(staffDetails.getRole());
            // Add more fields as necessary

            return staffRepository.save(existingStaff);
        } else {
            return null;
        }
    }
}

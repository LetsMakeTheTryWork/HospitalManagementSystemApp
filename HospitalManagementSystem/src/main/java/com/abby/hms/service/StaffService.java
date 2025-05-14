package com.abby.hms.service;

import com.abby.hms.model.Staff;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);
    Staff getStaffById(Long id);
    List<Staff> getAllStaff();
    void deleteStaff(Long id);
    Staff updateStaff(Long id, Staff staffDetails);
}

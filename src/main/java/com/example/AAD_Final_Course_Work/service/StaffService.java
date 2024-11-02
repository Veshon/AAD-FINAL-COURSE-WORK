package com.example.AAD_Final_Course_Work.service;

import com.example.AAD_Final_Course_Work.dto.StaffStatus;
import com.example.AAD_Final_Course_Work.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO> getAllStaff();
    StaffStatus getStaff(String id);
    void deleteStaff(String id);
    void updateStaff(String id, StaffDTO staffDTO);
}

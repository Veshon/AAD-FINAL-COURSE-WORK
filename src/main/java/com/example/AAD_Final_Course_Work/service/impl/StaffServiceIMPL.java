package com.example.AAD_Final_Course_Work.service.impl;

import com.example.AAD_Final_Course_Work.dao.StaffDAO;
import com.example.AAD_Final_Course_Work.dto.impl.StaffDTO;
import com.example.AAD_Final_Course_Work.entity.impl.StaffEntity;
import com.example.AAD_Final_Course_Work.exception.DataPersistException;
import com.example.AAD_Final_Course_Work.service.StaffService;
import com.example.AAD_Final_Course_Work.util.AppUtil;
import com.example.AAD_Final_Course_Work.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class StaffServiceIMPL implements StaffService {

    @Autowired
    public StaffDAO staffDAO;

    @Autowired
    public Mapping mapping;


    @Override
    public void saveStaff(StaffDTO staffDTO) {
        staffDTO.setId(AppUtil.generateStaffId());

        StaffEntity savedStaff =
                staffDAO.save(mapping.toStaffEntity(staffDTO));
        if (savedStaff == null) {
            throw new DataPersistException("Staff not saved");
        }
    }
}

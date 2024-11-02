package com.example.AAD_Final_Course_Work.dto.impl;

import com.example.AAD_Final_Course_Work.dto.StaffStatus;
import com.example.AAD_Final_Course_Work.entity.Desig;
import com.example.AAD_Final_Course_Work.entity.Gender;
import com.example.AAD_Final_Course_Work.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StaffDTO implements StaffStatus {
    private String id;
    private String firstName;
    private String lastName;
    private Desig designation;
    private Gender gender;
    private String joinedDate;
    private String dob;
    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNo;
    private String email;
    private Role role;
    private String fieldCode;
    private String vehicleCode;
    private String equipmentId;

}

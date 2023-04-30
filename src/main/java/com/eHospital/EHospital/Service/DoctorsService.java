package com.eHospital.EHospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eHospital.EHospital.Model.Doctors;

@Service
public interface DoctorsService {
    
    // get all doctors
    List <Doctors> getAllDoctors();

    // get doctor by id
    Optional <Doctors> getDoctorsByID(String id);

    // update doctor by id
    ResponseEntity <String> updateDoctorInfoByID(String id);
}

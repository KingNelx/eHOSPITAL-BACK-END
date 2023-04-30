package com.eHospital.EHospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eHospital.EHospital.Model.Doctors;

@Service
public interface DoctorsService {

    // get all doctors
    List<Doctors> getAllDoctorsInfo();

    // get doctor by id
    Optional<Doctors> getDoctorsInfoByID(String id);

    // update doctor by id
    ResponseEntity<String> updateDoctorsInfoByID(String id, Doctors updateDoctors);

    // update certifications
    ResponseEntity <String> updateCertifications(String id, List <String> certifications);
}

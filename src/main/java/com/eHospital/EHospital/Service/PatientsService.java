package com.eHospital.EHospital.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eHospital.EHospital.Model.Patients;

@Service
public interface PatientsService {

    // get all patients
    List <Patients> getAllPatients();

    // get patient with ID
    Optional <Patients> getPatientByID(String id);

    // delete patient by ID
    ResponseEntity <String> deletePatientInfoByID(String id);

    // update patients
    ResponseEntity <String> updatePatientsInfoByID(String id, Patients updatePatients);

}

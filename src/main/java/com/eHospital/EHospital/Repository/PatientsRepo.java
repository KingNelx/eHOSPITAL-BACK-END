package com.eHospital.EHospital.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eHospital.EHospital.Model.Patients;

public interface PatientsRepo extends MongoRepository <Patients, String> {
    
}

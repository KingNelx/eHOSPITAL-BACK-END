package com.eHospital.EHospital.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eHospital.EHospital.Model.Patients;

@Repository
public interface PatientsRepo extends MongoRepository <Patients, String> {
    
}

package com.eHospital.EHospital.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eHospital.EHospital.Model.Doctors;

public interface DoctorsRepo extends MongoRepository <Doctors, String> {
    
}

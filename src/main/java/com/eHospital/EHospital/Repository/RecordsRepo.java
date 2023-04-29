package com.eHospital.EHospital.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eHospital.EHospital.Model.Records;

public interface RecordsRepo extends MongoRepository <Records, String>{
    
}

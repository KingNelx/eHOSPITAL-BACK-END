package eHOSPITALBACKEND.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eHOSPITALBACKEND.Model.Patient;

@Repository
public interface PatientRepo extends MongoRepository <Patient, String> {
    
}

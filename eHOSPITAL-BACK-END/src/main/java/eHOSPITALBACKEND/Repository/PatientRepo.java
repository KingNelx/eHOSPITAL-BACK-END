package eHOSPITALBACKEND.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import eHOSPITALBACKEND.Model.Patient;


public interface PatientRepo extends MongoRepository <Patient, String> {
    
}

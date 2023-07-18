package eHOSPITALBACKEND.Repository;

import eHOSPITALBACKEND.Entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepo extends MongoRepository <Patient, String> {
}

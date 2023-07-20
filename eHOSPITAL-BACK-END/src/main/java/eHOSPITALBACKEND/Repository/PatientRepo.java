package eHOSPITALBACKEND.Repository;

import eHOSPITALBACKEND.Entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface PatientRepo extends MongoRepository <Patient, String> {
    List <Patient> findByByGender(String gender);
}

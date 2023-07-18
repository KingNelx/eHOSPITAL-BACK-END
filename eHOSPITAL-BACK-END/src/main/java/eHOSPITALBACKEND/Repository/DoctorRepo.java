package eHOSPITALBACKEND.Repository;

import eHOSPITALBACKEND.Entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepo extends MongoRepository <Doctor, String> {
}

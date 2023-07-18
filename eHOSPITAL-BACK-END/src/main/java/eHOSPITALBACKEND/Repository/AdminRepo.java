package eHOSPITALBACKEND.Repository;

import eHOSPITALBACKEND.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository <Admin, String> {
}

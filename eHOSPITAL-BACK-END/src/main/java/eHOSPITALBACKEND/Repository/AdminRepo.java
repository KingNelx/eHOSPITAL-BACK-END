package eHOSPITALBACKEND.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import eHOSPITALBACKEND.Model.Admin;

public interface AdminRepo extends MongoRepository<Admin, String> {
    Optional<Admin> findByEmail(String email);

    Optional<Admin> findyByUserName(String userName);

    Optional<Admin> findyByPassword(String password);
}

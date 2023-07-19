package eHOSPITALBACKEND.Repository;

import eHOSPITALBACKEND.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AdminRepo extends MongoRepository <Admin, String> {
    Optional <Admin> findByFirstName(String firstname);
    Optional <Admin> findByLastName(String lastname);
    Optional <Admin> findByPassword(String  password);
    Admin findByEmailAndUserNameAndPassword(String email, String username, String password);

}

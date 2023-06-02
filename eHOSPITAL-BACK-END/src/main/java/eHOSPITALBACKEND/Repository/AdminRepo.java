package eHOSPITALBACKEND.Repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import eHOSPITALBACKEND.Model.Admin;

public interface AdminRepo extends MongoRepository <Admin, String> {
    
    Optional <Admin> findByEmail(String email);
    Optional <Admin> findByUserName(String username);
    Admin findByUsernameAndEmailAndPassword(String email, String userName, String password);

}

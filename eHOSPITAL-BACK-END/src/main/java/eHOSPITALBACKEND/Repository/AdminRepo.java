package eHOSPITALBACKEND.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import eHOSPITALBACKEND.Model.Admin;

public interface AdminRepo extends MongoRepository<Admin, String> {

    Optional<Admin> findByEmail(String email);

    Optional<Admin> findByUsername(String username);

    Admin findByEmailAndUsernameAndPassword(String email, String username, String password);

    Admin findByUsernameAndPassword(String username, String password);
}

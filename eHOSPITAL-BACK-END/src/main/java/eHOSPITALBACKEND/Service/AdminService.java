package eHOSPITALBACKEND.Service;

import eHOSPITALBACKEND.Entity.Admin;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
@Service
public interface AdminService {

    // create admin account
    ResponseEntity <String> createAdminAccount(Admin createAdminAccount);

    // log in admin account
    ResponseEntity <String> logInAsAdmin(String userName, String email, String password);

    // get admins
    List <Admin> getAllAdmins();
    // get admin info by id

    // update admin info by id

    // delete admin info by id
}

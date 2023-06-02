package eHOSPITALBACKEND.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import eHOSPITALBACKEND.Model.Admin;

@Service
public interface AdminService {
    
    ResponseEntity <String> createAdminAccount(Admin createAdminAccount);
    ResponseEntity <String> logInAdmin(String email, String userName, String password);

}

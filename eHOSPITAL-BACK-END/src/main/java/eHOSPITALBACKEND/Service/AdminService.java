package eHOSPITALBACKEND.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import eHOSPITALBACKEND.Model.Admin;

@Service
public interface AdminService {
    
    ResponseEntity <String> registerAdmin(Admin registerAdmin);
    ResponseEntity <String> logInAdmin(String email, String username, String password);
    List <Admin> getAllAdmins();

}

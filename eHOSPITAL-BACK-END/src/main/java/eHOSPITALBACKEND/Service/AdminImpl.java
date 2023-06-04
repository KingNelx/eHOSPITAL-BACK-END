package eHOSPITALBACKEND.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;
import eHOSPITALBACKEND.Model.Admin;
import eHOSPITALBACKEND.Repository.AdminRepo;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity<String> registerAdmin(Admin registerAdmin) {
        Optional<Admin> existingEmail = adminRepo.findByEmail(registerAdmin.getEmail());
        Optional<Admin> existingUserName = adminRepo.findByUsername(registerAdmin.getUsername());

        if (existingEmail.isPresent() && existingUserName.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, " ADMIN INFO ALREADY EXISTED ");
        }

        adminRepo.save(registerAdmin);
        return ResponseEntity.ok(" ADMIN ACCOUNT CREATED ");

    }

    @Override
    public ResponseEntity<String> logInAdmin(@RequestParam String email, @RequestParam String username,
            @RequestParam String password) {
        Admin adminInfo = adminRepo.findByEmailAndUsernameAndPassword(email, username, password);
        if (adminInfo == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }

        adminRepo.findAll();
        return ResponseEntity.ok("Login Successful!");
    }

    @Override
    public List <Admin> getAllAdmins(){
        if(adminRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return adminRepo.findAll();
    }
}

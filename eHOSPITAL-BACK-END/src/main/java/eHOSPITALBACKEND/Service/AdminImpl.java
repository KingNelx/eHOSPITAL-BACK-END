package eHOSPITALBACKEND.Service;

import eHOSPITALBACKEND.Entity.Admin;
import eHOSPITALBACKEND.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminImpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> createAdminAccount(@RequestBody Admin createAdmin){
        Optional <Admin> existingFirstName = adminRepo.findByFirstName(createAdmin.getFirstName());
        Optional <Admin> existingLastName = adminRepo.findByLastName(createAdmin.getLastName());

        if(existingFirstName.isPresent() && existingLastName.isPresent()){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, " ADMIN ALREADY EXISTED ");
        }

        adminRepo.save(createAdmin);
        return ResponseEntity.ok(" ADMIN ACCOUNT CREATED ");
    }

    @Override
    public ResponseEntity <String> logInAsAdmin(@RequestParam String userName, @RequestParam String email, @RequestParam String password){
        Admin existingAdminInfo = adminRepo.findByEmailAndUserNameAndPassword(userName, email, password);

        if(existingAdminInfo != null){
               String hashedPassword = existingAdminInfo.getPassword();
               if(hashedPassword.equals(password)){
                   return ResponseEntity.ok(" LOG IN SUCCESSFULLY");
               }
               else{
                   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" INVALID USERNAME AND PASSWORD ");
               }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" INVALID USERNAME OR EMAIL");
    }

    @Override
    public List <Admin> getAllAdmins() {
        try{
            List <Admin> admins = adminRepo.findAll();
            if(admins.isEmpty()){
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ERROR MESSAGE: " + e);
        }
        return adminRepo.findAll();
    }

}

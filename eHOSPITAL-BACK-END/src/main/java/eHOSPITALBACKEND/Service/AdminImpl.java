package eHOSPITALBACKEND.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import eHOSPITALBACKEND.Model.Admin;
import eHOSPITALBACKEND.Repository.AdminRepo;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity<String> createAdminAccount(@RequestBody Admin newAdmin) {
        Optional<Admin> existingAdminEmail = adminRepo.findByEmail(newAdmin.getEmail());
        Optional<Admin> existingAdminUserName = adminRepo.findyByUserName(newAdmin.getUserName());
        Optional<Admin> existingAdminPassword = adminRepo.findyByPassword(newAdmin.getPassword());

        if (existingAdminEmail.isPresent() && existingAdminUserName.isPresent() && existingAdminPassword.isPresent()) {
            return ResponseEntity.ok(" ADMIN ALREADY EXISTED ");
        }

        adminRepo.save(newAdmin);
        return ResponseEntity.ok(" ADMIN ACCOUNT CREATED ");

    }
}

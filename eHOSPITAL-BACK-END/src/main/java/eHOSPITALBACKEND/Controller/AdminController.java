package eHOSPITALBACKEND.Controller;

import eHOSPITALBACKEND.Entity.Admin;
import eHOSPITALBACKEND.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-admin-account")
    ResponseEntity <String> createAdminAccount(@RequestBody Admin createAdmin){
        return adminService.createAdminAccount(createAdmin);
    }
}
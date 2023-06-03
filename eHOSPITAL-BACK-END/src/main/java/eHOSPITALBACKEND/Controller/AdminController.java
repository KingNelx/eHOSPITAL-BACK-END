package eHOSPITALBACKEND.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eHOSPITALBACKEND.Model.Admin;
import eHOSPITALBACKEND.Service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/registerAdmin")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin newAdmin) {
        return adminService.registerAdmin(newAdmin);
    }

    @GetMapping("/logInAdmin")
    public ResponseEntity<String> logInAdmin(@RequestParam String email, @RequestParam String username,
            @RequestParam String password) {
        return adminService.logInAdmin(email, username, password);
    }

}

package eHOSPITALBACKEND.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eHOSPITALBACKEND.Model.Patient;
import eHOSPITALBACKEND.Service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/registerPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient addPatient) {
        return patientService.addPatient(addPatient);
    } // e-hospital
}

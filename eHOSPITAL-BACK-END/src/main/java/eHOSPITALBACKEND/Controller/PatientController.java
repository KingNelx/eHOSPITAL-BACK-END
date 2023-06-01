package eHOSPITALBACKEND.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import eHOSPITALBACKEND.Model.Patient;
import eHOSPITALBACKEND.Service.PatientService;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "http://localhost:5173/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/registerPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient addPatient) {
        return patientService.addPatient(addPatient);
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/getPatientByID/{id}")
    public Optional<Patient> getPatientByID(@PathVariable String id) {
        return patientService.getPatientByID(id);
    }

    @PutMapping("/updatePatientData/{id}")
    public ResponseEntity<String> updatePatientData(@PathVariable String id, @RequestBody Patient newPatient) {
        return patientService.updatePatientInfo(id, newPatient);
    }

    @DeleteMapping("/removePatientsData/{id}")
    public ResponseEntity<String> deletePatientsData(@PathVariable String id) {
        return patientService.removePatientsData(id);
    }

}

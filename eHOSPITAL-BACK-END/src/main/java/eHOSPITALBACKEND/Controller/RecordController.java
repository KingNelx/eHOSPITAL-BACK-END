package eHOSPITALBACKEND.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import eHOSPITALBACKEND.Model.Records;
import eHOSPITALBACKEND.Service.RecordsService;

@RestController
@RequestMapping("/api/records")

public class RecordController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/getAllRecords")
    public List<Records> getAllRecords() {
        return recordsService.getAllRecords();
    }

    @GetMapping("/getRecordByID/{id}")
    public Optional<Records> getRecordsByID(@PathVariable String id) {
        return recordsService.getRecordsById(id);
    }

}

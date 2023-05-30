package eHOSPITALBACKEND.Service;

import org.springframework.stereotype.Service;

import eHOSPITALBACKEND.Model.Records;

import java.util.List;
import java.util.Optional;

@Service
public interface RecordsImpl {
    
    // get all records
    List <Records> getAllRecords();

    // get records by id
    Optional <Records> getRecordsById(String id);
}

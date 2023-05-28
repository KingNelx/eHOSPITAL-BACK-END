package eHOSPITALBACKEND.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eHOSPITALBACKEND.Model.Records;

public interface RecordsRepo extends MongoRepository <Records, String> {
    
}

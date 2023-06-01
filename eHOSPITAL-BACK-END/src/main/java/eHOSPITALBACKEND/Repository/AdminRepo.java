package eHOSPITALBACKEND.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eHOSPITALBACKEND.Model.Admin;

public interface AdminRepo extends MongoRepository <Admin, String>{
    
}

package eHOSPITALBACKEND.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import eHOSPITALBACKEND.Model.Records;
import eHOSPITALBACKEND.Repository.RecordsRepo;
import java.util.Optional;

@Service
public class RecordsService implements RecordsImpl {

    @Autowired
    private RecordsRepo recordsRepo;

    @Override
    public List <Records> getAllRecords(){
        if(recordsRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return recordsRepo.findAll();
    }

    @Override
    public Optional <Records> getRecordsById(@PathVariable String id){
        if(!recordsRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return recordsRepo.findById(id);
    }

}

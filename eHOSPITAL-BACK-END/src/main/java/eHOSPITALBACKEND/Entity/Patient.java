package eHOSPITALBACKEND.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import jakarta.persistence.ElementCollection;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection = "Patients")
public class Patient {

    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String age;
    private @Getter @Setter String temporaryAddress;
    private @Getter @Setter String permanentAddress;
    @ElementCollection
    private @Getter @Setter List <String> medicalRecords;
}

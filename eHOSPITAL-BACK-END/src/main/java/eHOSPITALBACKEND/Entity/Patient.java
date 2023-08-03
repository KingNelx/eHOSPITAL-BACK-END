package eHOSPITALBACKEND.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document(collection = "Patient")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String dateOfBirth;
    private @Getter @Setter String gender;
    private @Getter @Setter String contactInformation;
    private @Getter @Setter String address;
    private @Getter @Setter String isVaccinated;
    @ElementCollection
    private @Getter @Setter String medicalHistory;
    @ElementCollection
    private @Getter @Setter String currentMedication;

}

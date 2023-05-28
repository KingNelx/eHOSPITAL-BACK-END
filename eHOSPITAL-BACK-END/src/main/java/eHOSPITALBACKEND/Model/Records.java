package eHOSPITALBACKEND.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Document (collection = "Records")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Records {

    @Id
    private @Getter @Setter String id;
    private @Getter @Setter int patientID;
    private @Getter @Setter String emergencyContact;
    @ElementCollection
    private @Getter @Setter List<String> vitalSigns;
    @ElementCollection
    private @Getter @Setter List<String> laboratory;
    @ElementCollection
    private @Getter @Setter List <String> medications;
}

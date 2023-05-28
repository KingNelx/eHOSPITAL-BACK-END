package eHOSPITALBACKEND.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Document
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

package eHOSPITALBACKEND.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "Doctor")
public class Doctor {
    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String contactNumber;
    private @Getter @Setter String email;
    private @Getter @Setter String userName;
    private @Getter @Setter String password;
}

package eHOSPITALBACKEND.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;

@Entity
@Document(collection = "Admins")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    
    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String email;
    private @Getter @Setter String password;
}

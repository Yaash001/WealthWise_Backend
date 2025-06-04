package in.starmaven.wealthwise.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;

@Document(collection  = "users") //MONGODB COLLECTION NAME 
@Data
public class User {

    @Id 
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;

    public String fullName() {
        return (firstName+" "+(middleName != null ? middleName + " ": "")+lastName);
    }

    private String email;
    private String password;
    private String contactNumber;
    private String role = "USER"; // User role (ADMIN / USER)
    private String family_name;  // This field is not stored in the database

    @DBRef
    private Family family; // Refercence to family document
}
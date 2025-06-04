package in.starmaven.wealthwise.entity;

import org.springframework.data.mongodb.core.index.Indexed;
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
    private String passWord;
    private String contactNumber;
    private String role; // User role (ADMIN / USER)

   
   //for full name
   
   @DBRef
   private Family family;
    // Refercence to family document
}
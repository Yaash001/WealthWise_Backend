//package in.starmaven.wealthwise.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//
//@Entity //it marks this class is database table
//@Table(name = "users")
//@Data
//public class User {
//
//    @Id //for primary key
//    @GeneratedValue(strategy = GenerationType.IDENTITY)     //for automatic genration
//    private Long id;
//
//    @Column(nullable = false)
//    private String firstName;
//
//    private String middleName;
//
//    @Column(nullable = false)
//    private String lastName;
//
//    //for full name
//    public String fullName() {
//        return (firstName+" "+(middleName != null ? middleName + " ": "")+lastName);
//    }
//
//    @Column(unique = true,nullable = false) //allow unique values and notnull
//    private String email;
//
//    private String password;
//
//    @Column(nullable = false, length = 15)  // max length=15
//    private String contactNumber;
//
//    @ManyToOne  //many user has one family it is Foreign key
//    @JoinColumn(name = "family_id", nullable = false)
//    private Family family;
//}

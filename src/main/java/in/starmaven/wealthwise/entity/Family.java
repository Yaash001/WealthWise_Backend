package in.starmaven.wealthwise.entity;

import lombok.*;
import java.io.Serializable;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "family") //collection nme
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Family implements Serializable {
    
    @Id
    private String id;

    @Field()
    private String name;

    @Pattern(regexp = "ACTIVE|DEACTIVE", message = "Status must be ACTIVE or DEACTIVE")
    private String status = "Active";
}


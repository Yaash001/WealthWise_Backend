package in.starmaven.wealthwise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "families") //collection nme
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Family implements Serializable {
    @Id
    private String id;

    private String name;

    private String status;
}


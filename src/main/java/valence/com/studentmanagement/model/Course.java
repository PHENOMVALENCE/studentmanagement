package valence.com.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private String description; 
    private String instructor;
    private String credits;
}

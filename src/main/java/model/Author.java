package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue()
    private Integer id; /* We use Integer because  Integer is by default null rather int is 0
    so when a value is there JPA tries to find data if it is null it tries to insert data*/
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}

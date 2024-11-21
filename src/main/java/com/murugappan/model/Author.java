package com.murugappan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // cant be used for complex keys like composite keys must be used in conjunction with @ID
    // AUTO Lets hibernate decide the best strategy in SQL it uses a table in postgres it uses sequence+30
    private Integer id; /* We use Integer because  Integer is by default null rather int is 0
    so when a value is there JPA tries to find data if it is null it tries to insert data*/
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private Integer age;
    @Column(updatable = false)
    @CreatedDate
    private LocalDate createdDate;
    @LastModifiedDate
    private LocalDate lastModified;
    @ManyToMany(mappedBy = "autorList")
    private List<Courses> courseList;
}

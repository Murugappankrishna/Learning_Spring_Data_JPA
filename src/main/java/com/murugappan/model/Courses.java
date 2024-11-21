package com.murugappan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(updatable = false)
    @CreatedDate
    private LocalDate createdDate;
    @LastModifiedDate
    private LocalDate updatedDate;
    @ManyToMany
    @JoinTable(
            name = "course_author",
            joinColumns = {
                    @JoinColumn(name="course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="author_id")
            }

    )

    private List<Author> autorList;
}

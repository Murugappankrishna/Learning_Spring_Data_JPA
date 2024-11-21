package com.murugappan.repo;

import com.murugappan.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepo extends JpaRepository<Author,Integer>{
}

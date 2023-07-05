package com.javafullstack.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafullstack.student.model.Proffessor;

@Repository
public interface ProffessorRepository extends JpaRepository<Proffessor, Long> {

}

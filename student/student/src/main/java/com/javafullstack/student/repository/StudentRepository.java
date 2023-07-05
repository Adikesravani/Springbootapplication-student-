package com.javafullstack.student.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javafullstack.student.model.Student;

import com.javafullstack.student.model.Student.StudentDTOIntf;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(value="select s.id as stu_id,s.Total,s.Student_name,from student s, student s, proffessor p where s.pid=p.pid and pid=:pid",nativeQuery=true)
	List<StudentDTOIntf>
	getStudentProDetails(@Param("pid")int pid);

}

package valence.com.studentmanagement.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valence.com.studentmanagement.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

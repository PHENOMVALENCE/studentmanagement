package valence.com.studentmanagement.repository;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import valence.com.studentmanagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    // Custom query to get recent N students by enrollment date
    @Query(value = "SELECT s FROM Student s ORDER BY s.enrollmentDate DESC")
    List<Student> findTopNByOrderByEnrollmentDateDesc(org.springframework.data.domain.Pageable pageable);

    // Helper method to pass int directly
    default List<Student> findTopNByOrderByEnrollmentDateDesc(int limit) {
        return findTopNByOrderByEnrollmentDateDesc(org.springframework.data.domain.PageRequest.of(0, limit));
    
    }
       @Query("SELECT s FROM Student s ORDER BY s.enrollmentDate DESC")
    List<Student> findTopNStudents(Pageable pageable);

     List<Student> findByOrderByEnrollmentDateDesc(org.springframework.data.domain.Pageable pageable);
}

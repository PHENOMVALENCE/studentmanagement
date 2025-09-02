package valence.com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import valence.com.studentmanagement.model.Enrollment;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    @Query("SELECT e FROM Enrollment e ORDER BY e.enrollmentDate DESC")
    List<Enrollment> findRecentEnrollments(Pageable pageable);

    default List<Enrollment> findRecentEnrollments(int limit) {
        return findRecentEnrollments(org.springframework.data.domain.PageRequest.of(0, limit));
    }

    List<Enrollment> findTop5ByOrderByEnrollmentDateDesc();
}

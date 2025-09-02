package valence.com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valence.com.studentmanagement.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}    


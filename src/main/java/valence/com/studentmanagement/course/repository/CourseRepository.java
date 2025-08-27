package valence.com.studentmanagement.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valence.com.studentmanagement.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}    


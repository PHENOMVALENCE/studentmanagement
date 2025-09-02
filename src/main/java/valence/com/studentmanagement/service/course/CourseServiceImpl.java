package valence.com.studentmanagement.service.course;

import java.util.List;
import valence.com.studentmanagement.repository.EnrollmentRepository;



import org.springframework.stereotype.Service;

import valence.com.studentmanagement.model.Course;
import valence.com.studentmanagement.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

  
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public int countTotalEnrollments() {
        return (int) enrollmentRepository.count();
    }
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();

    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setName(course.getName());
            existingCourse.setDescription(course.getDescription());
            return courseRepository.save(existingCourse);
        }
        return null;
    }
    

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);

    
    }

     @Override
    public int countAllCourses() {
        return (int) courseRepository.count();
    }




    
}

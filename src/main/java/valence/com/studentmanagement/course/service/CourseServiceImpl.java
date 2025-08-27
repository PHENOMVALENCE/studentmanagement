package valence.com.studentmanagement.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import valence.com.studentmanagement.course.model.Course;
import valence.com.studentmanagement.course.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course Course);
    }

    @Override
    public Course updateCourse(int id, Course course) {
    return courseRepository.updateCourse();
    }

    @Override
    public void deleteCourse(int id) {
    
    }

    
}

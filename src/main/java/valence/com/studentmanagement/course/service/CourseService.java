package valence.com.studentmanagement.course.service;

import java.util.List;

import valence.com.studentmanagement.course.model.Course;

public interface CourseService {

    List<Course> getAllCourses();
      Course getCourseById(int id);
    Course createCourse(Course course);
    Course updateCourse(int id, Course course);
    void deleteCourse(int id);

    
    
}

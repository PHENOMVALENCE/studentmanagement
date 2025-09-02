package valence.com.studentmanagement.service.course;

import java.util.List;

import valence.com.studentmanagement.model.Course;

public interface CourseService {

    List<Course> getAllCourses();
      Course getCourseById(int id);
    Course createCourse(Course course);
    Course updateCourse(int id, Course course);
    void deleteCourse(int id);
int countAllCourses();
int countTotalEnrollments();

    
    
}

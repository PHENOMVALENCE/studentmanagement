package valence.com.studentmanagement.student.service;

import java.util.List;

import valence.com.studentmanagement.student.model.Student;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student createStudent(Student student);
    Student updateStudent(Integer id, Student student);
    void deleteStudent(Integer id);


}

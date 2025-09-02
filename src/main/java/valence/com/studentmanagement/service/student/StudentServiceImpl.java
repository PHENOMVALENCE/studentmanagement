package valence.com.studentmanagement.service.student;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import valence.com.studentmanagement.model.Student;
import valence.com.studentmanagement.repository.EnrollmentRepository;
import valence.com.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository,
                            EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
    
    @Override
    public int countAllStudents() {
        return (int) studentRepository.count();
    }

    @Override
    public List<Student> getRecentEnrollments(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        
        // Approach 1: If Student has enrollmentDate field
        return studentRepository.findByOrderByEnrollmentDateDesc(pageable);
    }
}
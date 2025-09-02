package valence.com.studentmanagement.service.enrollment;

import java.util.List;
import org.springframework.stereotype.Service;
import valence.com.studentmanagement.model.Enrollment;
import valence.com.studentmanagement.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public int countTotalEnrollments() {
        return (int) enrollmentRepository.count();
    }

    public List<Enrollment> getRecentEnrollments(int limit) {
        return enrollmentRepository.findTop5ByOrderByEnrollmentDateDesc();
    }
}
  


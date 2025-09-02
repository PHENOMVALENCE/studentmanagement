package valence.com.studentmanagement.service.enrollment;

import java.util.List;

import valence.com.studentmanagement.model.Enrollment;

public interface EnrollmentService {
    int countTotalEnrollments();
    List<Enrollment> getRecentEnrollments(int limit);
}

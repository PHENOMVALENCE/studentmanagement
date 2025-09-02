package valence.com.studentmanagement.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import valence.com.studentmanagement.service.student.StudentService;
import valence.com.studentmanagement.service.course.CourseService;
import valence.com.studentmanagement.service.enrollment.EnrollmentService;
import valence.com.studentmanagement.service.parent.ParentService;

@Controller
public class DashboardController {

    private final StudentService studentService;
    private final ParentService parentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public DashboardController(StudentService studentService,
                               ParentService parentService,
                               CourseService courseService,
                               EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.parentService = parentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    @GetMapping({"/", "/dashboard"})
    public String showDashboard(Model model) {
        model.addAttribute("featureName", "Dashboard");

        // Statistics
        model.addAttribute("totalStudents", studentService.countAllStudents());
        model.addAttribute("totalParents", parentService.countAllParents());
        model.addAttribute("totalCourses", courseService.countAllCourses());
        model.addAttribute("totalEnrollments", enrollmentService.countTotalEnrollments());

        // Recent enrollments (last 5)
        model.addAttribute("recentEnrollments", enrollmentService.getRecentEnrollments(5));

        return "dashboard";
    }
}

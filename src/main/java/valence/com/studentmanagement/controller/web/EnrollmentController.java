package valence.com.studentmanagement.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import valence.com.studentmanagement.service.*;
import valence.com.studentmanagement.service.course.CourseService;
import valence.com.studentmanagement.service.enrollment.EnrollmentService;
import valence.com.studentmanagement.service.student.*;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public EnrollmentController(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/form")
    public String showEnrollmentForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourses());
        return "enroll";
    }

    @PostMapping("/submit")
    public String handleEnrollment(@RequestParam Integer studentId, @RequestParam Integer courseId, Model model) {
        try {
            enrollmentService.enrollStudent(studentId, courseId);
            model.addAttribute("message", "Enrollment successful!");
            model.addAttribute("isSuccess", true);
        } catch (Exception e) {
            model.addAttribute("message", "Enrollment failed: " + e.getMessage());
            model.addAttribute("isSuccess", false);
        }
        
        // Re-add students and courses to display the form again with the result
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourses());
        
        return "enroll";
    }
}
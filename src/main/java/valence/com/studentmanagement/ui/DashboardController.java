package valence.com.studentmanagement.ui;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



// You can create a new controller specifically for the dashboard
// or add this method to an existing HomeController
@Controller
public class DashboardController {

    // You would inject your services here to get the data
    // @Autowired
    // private StudentService studentService;
    // @Autowired
    // private ParentService parentService;
    // @Autowired
    // private CourseService courseService;

    @GetMapping("/")
    public String showDashboard(Model model) {
        
        // Add the 'featureName' to the model so the fragments can render correctly
        model.addAttribute("featureName", "Dashboard");

        // Fetch data and add it to the model.
        // Replace the placeholders below with actual service calls.
        int totalStudents = 125; // studentService.countAllStudents();
        int totalParents = 89;   // parentService.countAllParents();
        int totalCourses = 15;   // courseService.countAllCourses();

        model.addAttribute("totalStudents", totalStudents);
        model.addAttribute("totalParents", totalParents);
        model.addAttribute("totalCourses", totalCourses);

        return "dashboard"; // This tells Spring Boot to render the 'dashboard.html' template
    }
}
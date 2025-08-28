package valence.com.studentmanagement.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import valence.com.studentmanagement.course.model.Course;
import valence.com.studentmanagement.course.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseViewController {
    @Autowired
    private CourseService courseService;
    public CourseViewController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @GetMapping("/list")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("activeFeature", "Course");
        return "course/list";
    }
    @GetMapping("/create")
    public String createCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "course/add";
    }
    @PostMapping("/create")
    public String createCourse(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/courses/list";
    }
    @GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable int id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "course/add";
    }
    @PostMapping("/edit/{id}")
    public String editCourse(@PathVariable int id, @ModelAttribute Course course) {
        courseService.updateCourse(id, course);
        return "redirect:/courses/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/list";
    }

}

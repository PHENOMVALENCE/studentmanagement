package valence.com.studentmanagement.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.ModelAttribute;
import valence.com.studentmanagement.student.model.Student;
import valence.com.studentmanagement.student.service.StudentService;

@Controller
@RequestMapping("/students")
@Tag(name = "Student Management", description = "APIs for student management")


public class StudentViewController {
    private final StudentService studentService;

    public StudentViewController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("featureName", "Student");
        return "student/list";
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/add";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
    // Add this method for View action
    @GetMapping("/{id}")
    public String viewStudent(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/view"; // create this view template
    }

    // Add this method for Edit action
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/add";
    }

    // Optionally change delete to GET (not recommended for destructive operations)
    @GetMapping("/delete/{id}")
    public String deleteStudentGet(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

}
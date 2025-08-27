package valence.com.studentmanagement.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import valence.com.studentmanagement.student.model.Student;
import valence.com.studentmanagement.student.service.StudentService;

@Controller
@RequestMapping("/students")

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

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
}
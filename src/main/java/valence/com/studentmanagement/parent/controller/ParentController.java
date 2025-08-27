package valence.com.studentmanagement.parent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import valence.com.studentmanagement.parent.model.Parent;
import valence.com.studentmanagement.parent.service.ParentService;

@RestController
public class ParentController {
    @Autowired
    private ParentService parentService;
    @GetMapping("/parents")
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/parents/{id}")
    public Parent getParentById(@PathVariable int id) {
        return parentService.getParentById(id);
    }
    @PostMapping("/parents")
    public Parent createParent(@ModelAttribute Parent parent) {
        return parentService.createParent(parent);
    }
    @PutMapping("/parents/{id}")
    public Parent updateParent(@PathVariable int id, @ModelAttribute Parent parent) {
        return parentService.updateParent(id, parent);
    }
    @DeleteMapping("/parents/{id}")
    public void deleteParent(@PathVariable int id) {
        parentService.deleteParent(id);
    }

}

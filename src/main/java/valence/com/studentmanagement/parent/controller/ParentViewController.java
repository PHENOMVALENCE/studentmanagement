package valence.com.studentmanagement.parent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import valence.com.studentmanagement.parent.model.Parent;
import valence.com.studentmanagement.parent.service.ParentService;

@Controller
@RequestMapping("/parents")
public class ParentViewController {

    @Autowired
    private final ParentService parentService;

    public ParentViewController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/list")
    public String getAllParents(Model model) {
        model.addAttribute("parents", parentService.getAllParents());
        model.addAttribute("featureName", "Parent");
        return "parent/list";
    }

    @GetMapping("/create")
    public String createParentForm(Model model) {
        model.addAttribute("parent", new Parent());
        model.addAttribute("featureName", "Parent");
        return "parent/add";
    }
      @GetMapping("/{id}")
    public String viewParent(@PathVariable Integer id, Model model) {
        model.addAttribute("parent", parentService.getParentById(id));
        return "parent/view"; // create this view template
    }

    @PostMapping("/create")
    public String createParent(@ModelAttribute Parent parent) {
        parentService.createParent(parent);
        return "redirect:/parents/list";
    }

    @GetMapping("/update/{id}")
    public String updateParentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("parent", parentService.getParentById(id));
        return "parent/add";
    }

    @PostMapping("/update/{id}")
    public String updateParent(@PathVariable Integer id, @ModelAttribute Parent parent) {
        parentService.updateParent(id, parent);
        return "redirect:/parents/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteParent(@PathVariable Integer id) {
        parentService.deleteParent(id);
        return "redirect:/parents/list";
    }
}

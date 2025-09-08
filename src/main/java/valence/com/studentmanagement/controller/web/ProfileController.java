package valence.com.studentmanagement.controller.web;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import valence.com.studentmanagement.model.User;
import valence.com.studentmanagement.service.user.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getProfile(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName())
                               .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "profile/view";
    }

    @GetMapping("/edit")
    public String editProfile(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName())
                               .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "profile/edit";
    }

    @PostMapping("/edit")
    public String updateProfile(@ModelAttribute("user") User updatedUser, Principal principal) {
        User user = userService.getUserByUsername(principal.getName())
                               .orElseThrow(() -> new RuntimeException("User not found"));

        // Update profile fields only
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setBio(updatedUser.getBio());
        user.setEmail(updatedUser.getEmail());

        userService.updateUser(user);
        return "redirect:/profile";
    }
}

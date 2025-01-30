package microservicetask_7.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import microservicetask_7.model.User;

@Controller
public class UserController {

    @GetMapping("/user/user")
    public String getUserPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (principal instanceof User) {
            User user = (User) principal;
            model.addAttribute("user", user);
        }
        return "user";
    }
}

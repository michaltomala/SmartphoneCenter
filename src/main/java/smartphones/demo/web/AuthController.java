package smartphones.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import smartphones.demo.entity.User;
import smartphones.demo.service.UserService;

@Controller
public class AuthController {

    private final UserService userService;


    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
//      todo - wyśrodkowanie formularza / ogólne poprawienie styli
        return "login";
    }


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
//      todo - wyśrodkowanie formularza / ogólne poprawienie styli
        return "register";
    }



}

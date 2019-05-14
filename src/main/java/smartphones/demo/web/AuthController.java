package smartphones.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import smartphones.demo.entity.User;
import smartphones.demo.service.UserService;
import pl.coderslab.model.Err;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult errors, Model model, HttpSession session){
        if (errors.hasErrors()) {
            return "login";
        }

        Err modelErr = new Err();

        userService.checkNameAndPassword(user,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("authErr", "Email albo hasło się nie zgadza!");
            return "login";
        }

        session.setAttribute("user", userService.findUser(user.getName()));
        if(user.isAdmin()) return "dashboard";
        return "redirect:/";

    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
//      todo - coding problem
        return "register";
    }


    @PostMapping("/register")
    public String register(@Valid User user, BindingResult errors,Model model,HttpSession session){

        if (errors.hasErrors()) {
            return "register";
        }

        Err modelErr = new Err();

        userService.checkPwd(user,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("pwdErr", "Hasła muszą być takie same!");
            return "register";
        }

        userService.checkIfNameIsUnique(user,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("nameErr", "Taki użytkownik już istnieje !");
            return "register";
        }

        userService.registerUser((user));
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.setAttribute("user",null);
        return "redirect:/";
    }




}

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
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult errors, Model model, HttpSession session){
        if (errors.hasErrors()) {
            return "auth/login";
        }

        Err modelErr = new Err();

        userService.checkNameAndPassword(user,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("authErr", "Email albo hasło się nie zgadza!");
            return "auth/login";
        }

        User checkedUser = userService.findUser(user.getName());
        session.setAttribute("user",checkedUser );
        if(checkedUser.isAdmin()) return "redirect:/admin/dashboard";
        return "redirect:/";

    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }


    @PostMapping("/register")
    public String register(@Valid User user, BindingResult errors,Model model,HttpSession session){

        if (errors.hasErrors()) {
            return "auth/register";
        }

        Err modelErr = new Err();

        userService.checkPwd(user,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("pwdErr", "Hasła muszą być takie same!");
            return "auth/register";
        }

        userService.checkIfNameIsUnique(user,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("nameErr", "Taki użytkownik już istnieje !");
            return "auth/register";
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

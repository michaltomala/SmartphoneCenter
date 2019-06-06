package smartphones.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {


//    todo - linear gradient in landing page
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String home(){

        return "home";
    }




}

package smartphones.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ArticleController {


    @RequestMapping(path = "/article"+"*",method = RequestMethod.GET)
    public String singleArticle(){

        return "singleArticle";
    }

//    todo - fix gradient
    @GetMapping("/articles")
    public String getArticles(){

        return "content/articles";
    }

}

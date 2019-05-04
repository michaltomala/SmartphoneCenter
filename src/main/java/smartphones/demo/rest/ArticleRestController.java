package smartphones.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import smartphones.demo.entity.Article;
import smartphones.demo.service.WebSearchService;

import java.util.List;


@RestController
@RequestMapping("/api/article/")
public class ArticleRestController {

    private final WebSearchService webSearchService;

    @Autowired
    public ArticleRestController(WebSearchService webSearchService) {
        this.webSearchService = webSearchService;
    }



    @RequestMapping(path = "komorkomania",method = RequestMethod.GET)
    public String findArticlesFromKomórkomania(){

        List<Article> articles = webSearchService.findArticlesFromKomorkomania();
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(articles);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }




//  todo add for single article

}

package smartphones.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(path = "komorkomania/section",method = RequestMethod.GET)
    public String findSectionInShortFromKomorkomania(){

        List<Article> articles = webSearchService.findSectionInShortFromKomorkomania();
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(articles);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }


    @RequestMapping(path = "tabletowo",method = RequestMethod.GET)
    public String findArticlesFromTabletowo(){

        List<Article> articles = webSearchService.findArticlesFromTabletowo();
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(articles);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }

    @RequestMapping(path = "{url}" , method = RequestMethod.GET)
    public String findSingleArticle(@PathVariable String url){

        Article article= webSearchService.findSingleArticle(url);
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(article);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }

//  todo add for single article

}

package smartphones.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartphones.demo.service.WebSearchService;


@RestController
@RequestMapping("/api/article/")
public class ArticleRestController {

    private final WebSearchService webSearchService;

    @Autowired
    public ArticleRestController(WebSearchService webSearchService) {
        this.webSearchService = webSearchService;
    }


}

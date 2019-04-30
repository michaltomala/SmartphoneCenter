package smartphones.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {

}

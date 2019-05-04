package smartphones.demo.service;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;


@Service
public class WebSearchService {



    public List<Article> findArticlesFromKomorkomania(){
        Connection connect = Jsoup.connect("https://komorkomania.pl/");
        List<Article> articleList = new ArrayList<>();

        try {
            Document document = connect.get();

            Elements articles = document.getElementsByTag("article");
            for (Element elem : articles) {
                Article article = new Article();

                if (setUrl(elem, article)) continue;
                setImage(elem, article);
                article.setHeader(elem.getElementsByTag("h2").text());

                articleList.add(article);

                if(articleList.size()==15) break;
            }
        } catch(IndexOutOfBoundsException e){
            return articleList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleList;

    }

    private void setImage(Element elem, Article article) {
        String picture = elem.getElementsByTag("picture").toString();
        int secondStart = picture.indexOf("<img ");
        int secondStop = picture.indexOf(".jpg\" width");
        if(secondStop==-1) {
            secondStart = picture.indexOf("data-src")+3;
            secondStop = picture.indexOf(".jpg\" class=\"lazyload\">");
        }
        String image = picture.substring(secondStart+10,secondStop+4);
        article.setImage(image);
    }

    private boolean setUrl(Element elem, Article article) {
        String figure = elem.getElementsByTag("figure").toString();
        int start = figure.indexOf("<a href=\"");
        int stop = figure.indexOf("<picture");
        if(start==-1 && stop==-1) return true;
        String url = figure.substring(start+9,stop-5);
        article.setUrl(url);
        return false;
    }


    public List<Article> findSectionInShortFromKomorkomania(){
        Connection connect = Jsoup.connect("https://komorkomania.pl/");
        List<Article> articleList = new ArrayList<>();

        try {
            Document document = connect.get();
            Elements links = document.getElementsByTag("ol");
            for (Element elem : links) {
                Elements elemChild = elem.children();
                for(Element e : elemChild){
                    Article article = new Article();
                    article.setHeader(e.text());
                    article.setUrl(e.child(0).attr("href"));
                    articleList.add(article);
                    if(articleList.size()==15) break;
                }
                if(articleList.size()==15) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleList;

    }





}

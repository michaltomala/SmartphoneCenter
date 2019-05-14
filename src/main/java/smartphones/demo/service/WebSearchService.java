package smartphones.demo.service;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import smartphones.demo.entity.Phone;


@Service
public class WebSearchService {

    private final PhoneService phoneService;

    @Autowired
    public WebSearchService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


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
            secondStart = picture.indexOf("data-src");
            secondStop = picture.indexOf(".jpg\" class=\"lazyload\">");
            if(secondStop==-1)secondStop = picture.indexOf(".png\" class=\"lazyload\">");
        }
        String image = picture.substring(secondStart+10,secondStop+4);

        if(image.startsWith("https:")){
            article.setImage(image);
        } else{
            String newImage = image.substring(3);
            article.setImage(newImage);
        }
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


    public Phone setAndReturnActualPhonePrice(String phoneName){

        Phone phone = phoneService.findPhone(phoneName);
        Connection connect = Jsoup.connect(phone.getCeneoUrl());
        try {

            Document document = connect.get();
            Element elem = document.select("span.price-int").first();
            int price = Integer.parseInt(elem.text());
            phone.setPrice(price);

        } catch (IOException e) {
            e.printStackTrace();
        }

        phoneService.savePhone(phone);
        return phone;
    }


    public List<Article> findArticlesFromTabletowo(){
        Connection connect = Jsoup.connect("https://www.tabletowo.pl/");
        List<Article> articleList = new ArrayList<>();
        try {

            Document document = connect.get();
            Elements divs = document.select("div.news clearfix");

            for (Element elem : divs) {

                Elements childElems = elem.children();

//                Article article = new Article();
//                article.setHeader();
//                article.setImage();
//                article.setUrl();
//                articleList.add(article);

                if(articleList.size()==5) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleList;

    }


    public Article findSingleArticle(String url){
        Connection connect = Jsoup.connect("https://komorkomania.pl/"+url.substring(8));
        Article article = new Article();

        try{
            Document document = connect.get();
            Elements header = document.select("header.article__header");

            for(Element h:header) {

                article.setHeader(h.child(0).text());

                Element image = h.getElementsByTag("picture").first().child(0);
                article.setImage(image.attr("srcset"));


                Element paragraf = h.child(2);
                String p = setTextWithoutLinks(paragraf);

                article.setText(p+"\n");
            }


            List<Element> elementList = document.getElementsByClass("article article-main-col");
            for(Element text:elementList){

                if(text.getElementsByTag("h2")!=null) article.setText(article.getText()+text+"\n");
                if(text.select("p.graf-500")!=null) {
                    String str = setTextWithoutLinks(text);
                    article.setText(article.getText()+str+"\n");
                }
                if(text.select("p.graf-250")!=null) {
                    String str = setTextWithoutLinks(text);
                    article.setText(article.getText()+str+"\n");
                }

                if(text.getElementsByTag("ul")!=null){
                    article.setText(article.getText()+text.toString());
                }

                if(text.select("figure.insert insert--size-m insert--color-transparent")!=null){
                    Elements picture = text.getElementsByTag("picture");
                    for(Element p:picture){
                        article.setText("\n"+p.child(0).attr("srcset")+"\n");
                    }
                }

                article.setText(article.getText()+"t.text()+\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return article;
    }

    private String setTextWithoutLinks(Element text) {
        Elements links = text.getElementsByTag("a");
        String str = text.toString();
        for (Element a : links) {
            str.replaceFirst(a.toString(), a.text());
        }
        return str;
    }


}

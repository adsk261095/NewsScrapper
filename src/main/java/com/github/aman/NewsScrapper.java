package com.github.aman;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsScrapper {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://economictimes.indiatimes.com/news/latest-news").get();
        List<NewsContent> news = new ArrayList<>();
        //To fetch all images in the webpage
        /*
        Elements ele = doc.select("* img");
        System.out.println(ele);
        for (Element e:ele
             ) {
            System.out.println(e.attr("src"));
        }
        */

        //To fetch the news
        String lastupdated = doc.select(".lastUpdated .flt").text();
        System.out.println(lastupdated);

        Elements newsList = doc.select(".data li");
        for (Element e:newsList
             ) {
            news.add(new NewsContent(e.select("a").text(), e.select("span").text(), e.select("p").text(),"https://economictimes.indiatimes.com" + e.select("a").attr("href")));
        }
        System.out.println(news);
        System.out.println(news.size());
    }
}

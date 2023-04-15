import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class WebCrawler {

    final String url;

    ArrayList<String> headings = new ArrayList<>();
    ArrayList<String> links = new ArrayList<>();
    ArrayList<String> funktionalLinks = new ArrayList<>();
    ArrayList<String> brokenLinks = new ArrayList<>();

    public WebCrawler(String url) {
        this.url = url;
    }


    public Website setWebsiteHeadingsAndLinks() {
        Website website = new Website();
        website.url = url;
        website.headings = crawlHeadings();
        website.functionalLinks = crawlFunctionalLinks();
        website.brokenLinks = crawlBrokenLinks();
        return  website;
    }

    private ArrayList<String> crawlHeadings() {
        try {
            Document document = Jsoup.connect(url).get();
            headings = getHeadings(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headings;
    }

    private ArrayList<String> getHeadings(Document document) {
        headings = new ArrayList<>();
        Elements elements = document.select("h1, h3, h3, h4, h5, h6");
        for (Element element : elements) {
            String heading = element.tagName()+" "+element.text(); // example output: "h1 Hello"
            headings.add(heading);
        }
        return headings;
    }

    private ArrayList<String> getLinks(Document document){ // finds all links of the webpage
        links = new ArrayList<>();
        Elements elements = document.select("a[href]");
        for(Element element: elements){
            String absUrl = element.absUrl("href");
            links.add(absUrl);
        }
        return links;
    }

    private ArrayList<String> crawlFunctionalLinks() {
        try{
            funktionalLinks = new ArrayList<>();
            Document document = Jsoup.connect(url).get();
            ArrayList<String> links = getLinks(document);
            for(String link: links){
                if(isValidLink(link)){
                    funktionalLinks.add(link);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
       return funktionalLinks;
    }

    private ArrayList<String> crawlBrokenLinks() {
        try{
            brokenLinks = new ArrayList<>();
            Document document = Jsoup.connect(url).get();
            ArrayList <String> links = getLinks(document);
            for (String link : links){
                if(!isValidLink(link)){
                    brokenLinks.add(link);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return brokenLinks;
    }

    private boolean isValidLink(String url){
           boolean isValid = false;

        try {
            Connection.Response response = Jsoup.connect(url).ignoreContentType(true).execute();
            int statusCode = response.statusCode();
            System.out.println("Found functional link: "+ url+" with status code "+statusCode);// todo: delete later
            if(statusCode==200){
                isValid=true;
            }
        } catch (HttpStatusException e1) {
            System.out.println("Found broken link: " + url + " with status code " + e1.getStatusCode()); // todo: delete later
        } catch (UnknownHostException e2) {
            System.out.println("Found broken link: " + url + " with unknown host"); // todo: delete later
        }catch (IOException e3){
            System.out.println("IOException has occured: "+ url); // todo: delete later
        }
           return isValid;
           }
    }



/*
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteCrawler {
    public static void main(String[] args) {
        String url = "https://example.com"; // replace with the URL of the website you want to crawl
        try {
            Document doc = Jsoup.connect(url).get(); // connect to the website and retrieve its HTML
            List<String> headingTexts = getHeadingTexts(doc); // get the heading texts
            List<String> linkUrls = getLinkUrls(doc); // get the link URLs
            System.out.println("Headings:");
            for (String headingText : headingTexts) {
                System.out.println(headingText); // print each heading text
            }
            System.out.println("Links:");
            for (String linkUrl : linkUrls) {
                System.out.println(linkUrl); // print each link URL
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getHeadingTexts(Document doc) {
        Elements headings = doc.select("h1, h2, h3, h4, h5, h6"); // select all headings
        List<String> headingTexts = new ArrayList<>();
        for (Element heading : headings) {
            headingTexts.add(heading.text()); // store the text of each heading in the array
        }
        return headingTexts;
    }

    public static List<String> getLinkUrls(Document doc) {
        Elements links = doc.select("a[href]"); // select all links
        List<String> linkUrls = new ArrayList<>();
        for (Element link : links) {
            linkUrls.add(link.attr("abs:href")); // store the absolute URL of each link in the array
        }
        return linkUrls;
    }
}

 */

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;

public class WebCrawler {

    final String url;

    ArrayList<String> headings = new ArrayList<>();
    ArrayList<String> links = new ArrayList<>();
    ArrayList<String> funktionalLinks = new ArrayList<>();
    ArrayList<String> brokenLinks = new ArrayList<>();


    public WebCrawler(String url) {
        this.url = url;
    }


    private Document connectToURL(String url) {
        try {
            return Jsoup.connect(url).get();      //return an instance of Document
        } catch (IOException e) {
            System.out.println("Connection failed: IOException. ");
            return null;
        }
    }


    public Website getWebsiteHeadingsAndLinks() {
        Website website = new Website();
        website.url = url;
        //getLinks(connectToURL(url));
        website.headings = crawlHeadings();
        website.functionalLinks = crawlFunctionalLinks();
        // website.brokenLinks = crawlBrokenLinks();
        return website;
    }

    private ArrayList<String> crawlHeadings() {
        headings = getHeadings(connectToURL(url));
        return headings;
    }

    private ArrayList<String> getHeadings(Document document) {
        Elements elements = document.select("h1, h3, h3, h4, h5, h6");
        for (Element element : elements) {
            String heading = element.tagName() + " " + element.text(); // example output: "h1 Hello"
            headings.add(heading);
        }
        return headings;
    }

    private ArrayList<String> getLinks(Document document) { // finds all links of the webpage
        HashSet<String> uniqueLinks = new HashSet<>();
        Elements elements = document.select("a[href]");
        for (Element element : elements) {
            String absUrl = element.absUrl("href");
            uniqueLinks.add(absUrl);
        }
        links = new ArrayList<>(uniqueLinks);
        return links;
    }

    private ArrayList<String> crawlFunctionalLinks() { //todo: remove duplication
        ArrayList<String> links = getLinks(connectToURL(url));
        for (String link : links) {
            if (isValidLink(link)) {
                funktionalLinks.add(link);
                // System.out.println("Functional link " + link); //todo: delete later
            }
        }
        return funktionalLinks;
    }

    private ArrayList<String> crawlBrokenLinks() {//todo: remove duplication
        ArrayList<String> links = getLinks(connectToURL(url));
        for (String link : links) {
            if (!isValidLink(link)) {
                brokenLinks.add(link);
                // System.out.println("Broken link: "+link); //todo: delete later
            }
        }
        return brokenLinks;
    }

    private boolean isValidLink(String url) {
        boolean isValid = false;

        try {
            Connection.Response response = Jsoup.connect(url).ignoreContentType(true).execute();
            int statusCode = response.statusCode();
            //System.out.println("Found functional link: "+ url+" with status code "+statusCode);// todo: delete later
            if (statusCode == 200) {
                isValid = true;
            }
        } catch (HttpStatusException e1) {
            System.out.println("Found broken link: " + url + " with status code " + e1.getStatusCode()); // todo: delete later
        } catch (UnknownHostException e2) {
            System.out.println("Found broken link: " + url + " with unknown host"); // todo: delete later
        } catch (IOException e3) {
            System.out.println("IOException has occurred: " + url); // todo: delete later
        } catch (Exception e) {
            System.out.println("Something went wrong" + e.getMessage());
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
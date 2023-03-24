import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WebCrawler {

    final String website;
    ArrayList<String> headings = new ArrayList<>();
    // ArrayList<String> links = new ArrayList<>();

    public WebCrawler(String website) {
        this.website = website;
    }


    public ArrayList<String> crawlHeadings() {
        try {
            Document document = Jsoup.connect(website).get();
            headings = getHeadings(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headings;
    }

    private ArrayList<String> getHeadings(Document document) {
        ArrayList<String> headings = new ArrayList<>();
        Elements elements = document.select("h1, h3, h3, h4, h5, h6");
        for (Element element : elements) {
            headings.add(element.text());
        }
        return headings;
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

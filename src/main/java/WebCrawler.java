import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebCrawler {
    String url;
    Website website = new Website();
    Document document;
    String absoluteUrl;

    public WebCrawler(String url) {
        this.url = url;
    }

    public Website getWebsiteHeadingsAndLinks() {
        // todo: make subroutines to make the function smaller and with less indentation

        website.url = url;
        try {
            document = Jsoup.connect(url).get();
            URL baseUrl = new URL(url);
            String baseDomain = baseUrl.getHost();

            for (int i = 0; i <= 6; i++) {
                Elements headings = document.select("h" + i);
                for (Element heading : headings) {
                    website.headings.add("h" + i + " " + heading.text());
                }
            }

            Elements links = document.select("a[href]");
            for (Element link : links) {
                absoluteUrl = link.absUrl("href");
                if (!absoluteUrl.isEmpty()) {
                    try {
                        URL linkUrl = new URL(absoluteUrl);
                        String linkDomain = linkUrl.getHost();

                        if (!linkDomain.contains(baseDomain)) {
                            addFunctionalOrBrokenLinksToWebsite();
                        }
                    } catch (MalformedURLException e) {
                       e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return website;
    }

    private void addFunctionalOrBrokenLinksToWebsite() {
        try {
            int statusCode = getStatusCodeFromJsoupConnect();
            if (statusCode >= 200 && statusCode < 400) {
                website.functionalLinks.add(absoluteUrl);
            } else {
                website.brokenLinks.add(absoluteUrl);
            }
        } catch (IOException e) {
            website.brokenLinks.add(absoluteUrl);
        }
    }
    private int getStatusCodeFromJsoupConnect() throws IOException {
        return Jsoup.connect(absoluteUrl)
                .ignoreHttpErrors(true)
                .method(org.jsoup.Connection.Method.HEAD)
                .execute()
                .statusCode();
    }
}

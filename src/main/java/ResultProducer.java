import java.util.ArrayList;

public class ResultProducer {
    UserData userData;
    WebsiteNode rootNode;
    StringBuilder report = new StringBuilder();
    ResultProducer(UserData userData, WebsiteNode rootNode) {
        this.userData = userData;
        this.rootNode = rootNode;
    }

    public String makeMdString() {
        report.append("# Web Crawler Report");
        report.append(newLine());
        report.append(assembleInput());
        report.append(newLine());

        recursiveAppend(rootNode, 0);

        return report.toString();
    }

    private void recursiveAppend(WebsiteNode websiteNode, int depth) {
        // todo: we made it work
        // todo: next we will make it clean

        if (websiteNode.getWebsite() != null) {
            String url = websiteNode.getWebsite().url;
            report.append(newLine());
            report.append(newLine());
            report.append(newLine());
            report.append(url);
            report.append(newLine());
            report.append(newLine());

            ArrayList<String> headings = websiteNode.getWebsite().headings;
            for (String heading : headings) {
                String[] headingLevelAndHeading = heading.split(" ", 2);
                // uses only the number of the string "h1 Example Heading", result: '1'
                int headingLevel = Integer.parseInt(headingLevelAndHeading[0].substring(1));

                for (int i = 0; i < headingLevel; i++) {
                    report.append("#");
                }
                report.append(" ").append(headingLevelAndHeading[1]).append(newLine());
            }

            report.append(newLine());
            report.append("Functional Links: ");
            report.append(newLine());
            report.append(newLine());

            ArrayList<String> functionalLinks = websiteNode.getWebsite().functionalLinks;
            for (String link : functionalLinks) {
                report.append(makeFunctionalLink(link));
            }

            report.append(newLine());
            report.append("Broken Links: ");
            report.append(newLine());
            report.append(newLine());

            ArrayList<String> brokenLinks = websiteNode.getWebsite().brokenLinks;
            for (String link : brokenLinks) {
                report.append(makeBrokenLink(link));
            }
        }

        // recursive call to children
        for (WebsiteNode child : websiteNode.getChildren()) {
            recursiveAppend(child, depth + 1);
        }
    }

    String newLine() {
        return "\n";
    }
    String assembleInput() {
        return "Starting Website: <a>" + userData.startingWebsite + "</a>\n"
                + "Crawling Depth: " + userData.crawlingDepth + "\n"
                + "Target Language: " + userData.targetLanguage + "\n";
    }

    String makeFunctionalLink(String text) {
        return "--> Functional Link to: <a>" + text + "</a>\n";
    }
    String makeBrokenLink(String text) {
        return "--> Broken Link to: <a>" + text + "</a>\n";
    }
}

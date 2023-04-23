public class ResultProducer {
    UserData userData;
    WebsiteNode websiteNode;
    StringBuilder report = new StringBuilder();
    ResultProducer(UserData userData, WebsiteNode websiteNode) {
        this.userData = userData;
        this.websiteNode = websiteNode;
    }

    String makeMdDocument() { // WebsiteNode websiteNode) {
        report.append("# Web Crawler Report");
        report.append(newLine());
        report.append(assembleInput());
        report.append(newLine());

        /*
        for (Website website: websiteNode) { // todo: change this to recursively read Website
            report.append(website.url);
            report.append(newLine());

            for (String heading : website.headings) {
                report.append(heading).append("\n"); // hashtags hinzufügen
            }
            for (String functionalLink : website.functionalLinks) {
                //
            }
        } */



        return report.toString();
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
        return "--> Link to: <a>" + text + "</a>";
    }
    String makeBrokenLink(String text) {
        return "--> Link to: <a>" + text + "</a>";
    }
}

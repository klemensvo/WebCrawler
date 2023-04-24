public class ResultProducer {
    UserData userData;
    WebsiteList websiteList;
    StringBuilder report = new StringBuilder();
    ResultProducer(UserData userData, WebsiteList websiteList) {
        this.userData = userData;
        this.websiteList = websiteList;
    }

    String makeMdDocument() { // WebsiteList websiteList) {
        report.append("# Web Crawler Report");
        report.append(newLine());
        report.append(assembleInput());
        report.append(newLine());

        for (Website website: websiteList) {
            report.append(website.url);
            report.append(newLine());

            for (String heading : website.translatedHeadings) {
                report.append(heading).append("\n"); // hashtags hinzufügen
            }
            for (String functionalLink : website.functionalLinks) {
                //
            }
        }



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

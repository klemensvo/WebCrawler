public class ResultProducer {
    UserData userData;
    Websites websites;
    StringBuilder report = new StringBuilder();
    ResultProducer(UserData userData, Websites websites) {
        this.userData = userData;
        this.websites = websites;
    }

    String makeMdDocument(Websites websites) {
        report.append("# Web Crawler Report");
        report.append(newLine());
        report.append(assembleInput());
        report.append(newLine());

        for (Website website: websites) {
            report.append(website.url);
            report.append(newLine());
            for (String heading : website.headings) {
                report.append(heading).append("\n");
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

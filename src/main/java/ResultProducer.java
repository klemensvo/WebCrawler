public class ResultProducer {
    UserData userData;
    Websites websites;
    StringBuilder report = new StringBuilder();
    ResultProducer(UserData userData, Websites websites) {
        this.userData = userData;
        this.websites = websites;
    }

    String makeMdDocument(Websites websites) {
        // StringBuilder report = new StringBuilder();
        report.append("# Web Crawler Report");
        report.append(newLine());
        report.append("Starting website: ");
        report.append(makeLink(userData.startingWebsite));
        report.append(newLine());



        return report.toString();
    }

    String newLine() {
        return "\n";
    }
    String makeLink(String text) {
        return "<a>" + text + "</a>";
    }

}

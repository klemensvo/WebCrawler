import java.util.ArrayList;

public class Translator {

    WebsiteNode rootNode;
    TargetLanguage targetLanguage;

    public Translator(WebsiteNode rootNode, String targetLanguage) {

    }

    public void translateWebsiteNodes() {



        recursiveTranslate(rootNode, 0);

        // return report.toString();
    }

    private void recursiveTranslate(WebsiteNode websiteNode, int depth) {

        // todo: Abbruchkriterium der Rekursion

        if (websiteNode.getWebsite() != null) {
            String url = websiteNode.getWebsite().url;

            ArrayList<String> headings = websiteNode.getWebsite().headings;

            for (String heading : headings) {
                String[] headingLevelAndHeading = heading.split(" ", 2);
                // uses only the number of the string "h1 Example Heading", result: '1'
                int headingLevel = Integer.parseInt(headingLevelAndHeading[0].substring(1));


                String headingToTranslate = headingLevelAndHeading[1]; // heading

                // Zauberei von Olha

                String translatedHeading = "";

                websiteNode.getWebsite().tranlatedHeadings.add(headingLevel + " "
                        + translatedHeading);
            }

        }

        // recursive call to children
        for (
                WebsiteNode child : websiteNode.getChildren()) {
            recursiveTranslate(child, depth + 1);
        }


    }
}
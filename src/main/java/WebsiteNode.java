import java.util.ArrayList;

public class WebsiteNode { //extends ArrayList<Website> {
    // private String url;
    private Website website;
    private WebsiteNode parent;
    private ArrayList<WebsiteNode> children = new ArrayList<>();

    /*
    public WebsiteNode() {
        // this.url = url;
        this.children = new ArrayList<>(); // todo: move to variable declaration? delete?
    } */

    public void addChild(WebsiteNode child) {
        child.setParent(this);
        children.add(child);
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public WebsiteNode getParent() {
        return parent;
    }

    public void setParent(WebsiteNode parent) {
        this.parent = parent;
    }

    public ArrayList<WebsiteNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<WebsiteNode> children) {
        this.children = children;
    }
}

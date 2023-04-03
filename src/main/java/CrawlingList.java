import java.util.ArrayList;
import java.util.Iterator;

public class CrawlingList<Website> {
    protected ArrayList<Website> websiteList;
    protected Iterator<Website> websiteIterator;

    public CrawlingList() {
        websiteList = new ArrayList<>();
        websiteIterator = websiteList.iterator();
    }

    public void add(Website website) {
        websiteList.add(website);
        websiteIterator = websiteList.iterator();
    }

    public boolean hasNext() {
        return websiteIterator.hasNext();
    }

    public Website next() {
        return websiteIterator.next();
    }
}

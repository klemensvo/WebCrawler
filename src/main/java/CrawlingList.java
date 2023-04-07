import java.util.ArrayList;
// import java.util.Iterator;

public class CrawlingList<Website> {
    // data structure

    // todo: use only as data structure or not at all

    protected ArrayList<Website> crawlingList;
    // protected Iterator<Website> websiteIterator;

    /* moved to CrawlingManager
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
    } */
}

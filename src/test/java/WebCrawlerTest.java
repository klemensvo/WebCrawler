import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

public class WebCrawlerTest {

    @Mock
    private Document document;

    @Mock
    private Connection connection;

    @Mock
    private Connection.Response response;

    private WebCrawler webCrawler;
    private String testUrl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUrl = "https://example.com";
        webCrawler = new WebCrawler(testUrl);
    }

    @Test
    void manuallyCrawlWebsite() {
        // remarks: I tried every way of mocking, but did not manage...

        WebCrawler webCrawler = new WebCrawler("https://javatpoint.com");
        // WebCrawler webCrawler = new WebCrawler("https://w3schools.com");

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        System.out.println("\nWebsite: " + website.url);
        System.out.println("\nHeadings: ");
        int headerCounter = 1;
        for (String heading : website.headings) {
            System.out.println(headerCounter + " " + heading);
            headerCounter++;
        }
        int funcionalLinkCounter = 1;
        System.out.println("\nFunctional Links:");
        for (String functionalLink : website.functionalLinks) {
            System.out.println(funcionalLinkCounter + " " + functionalLink);
            funcionalLinkCounter++;
        }
        int brokenLinkCounter = 1;
        System.out.println("\nBroken Links:");
        for (String brokenLink : website.brokenLinks) {
            System.out.println(brokenLinkCounter + " " + brokenLink);
            brokenLinkCounter++;
        }

        assertEquals("h1 Latest Tutorials", website.headings.get(0));


        // todo: delete the commented out code below later

        /*
        // Mock document and elements
        Elements headings = new Elements();
        Elements links = new Elements();

        // when(Jsoup.connect(anyString())).thenReturn(connection);
        // when(Jsoup.connect(Mockito.anyString())).thenReturn(connection);
        when(Jsoup.connect(argThat(url -> url != null && !url.isEmpty()))).thenReturn(connection);

        when(connection.get()).thenReturn(document);
        when(document.select(anyString())).thenReturn(headings, links);
        when(connection.method(Mockito.any())).thenReturn(connection);
        when(connection.ignoreHttpErrors(Mockito.anyBoolean())).thenReturn(connection);
        when(connection.execute()).thenReturn(response);
        when(response.statusCode()).thenReturn(200);

        // Perform test
        Website website = webCrawler.getWebsiteHeadingsAndLinks();

        // Assertions
        assertNotNull(website);
        assertEquals(testUrl, website.url);
    } */
    }
}



/*
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

interface JsoupConnector {
    Connection connect(String url);
}

class JsoupConnectorImpl implements JsoupConnector {
    @Override
    public Connection connect(String url) {
        return Jsoup.connect(url);
    }
}

public class WebCrawlerTest {
    private WebCrawler webCrawler;
    private String testUrl = "https://example.com";

    @BeforeEach
    public void setUp() {
        webCrawler = new WebCrawler(testUrl);
    }

    @Test
    void testGetWebsiteHeadingsAndLinks() throws IOException {
        // Crear un mock de Document
        Document mockDocument = Mockito.mock(Document.class);

        // Crear un mock de Connection
        Connection mockConnection = Mockito.mock(Connection.class);

        // Establecer el comportamiento del mock de Jsoup.connect()
        when(Jsoup.connect(testUrl)).thenReturn(mockConnection);

        // Establecer el comportamiento del mock de Connection.get()
        when(mockConnection.get()).thenReturn(mockDocument);

        // Establecer el comportamiento del mock de Connection.execute()
        Connection.Response mockResponse = Mockito.mock(Connection.Response.class);
        when(mockConnection.ignoreHttpErrors(true)).thenReturn(mockConnection);
        when(mockConnection.execute()).thenReturn(mockResponse);
        when(mockResponse.statusCode()).thenReturn(200);

        // Agregar más comportamientos de mock para Document.select() y otros métodos según sea necesario

        // Llamar al método getWebsiteHeadingsAndLinks() y verificar si devuelve un objeto Website no nulo
        Website result = webCrawler.getWebsiteHeadingsAndLinks();
        assertNotNull(result);
    }
} */
    /*
    @Test
    public void testGetWebsiteHeadingsAndLinks() throws IOException {
        // Mock the Jsoup connection and document objects
        Connection mockConnection = Mockito.mock(Connection.class);
        Connection.Response mockResponse = Mockito.mock(Connection.Response.class);
        Document mockDocument = Mockito.mock(Document.class);
        Elements mockHeadings = Mockito.mock(Elements.class);
        Elements mockLinks = Mockito.mock(Elements.class);

        // Stub the Jsoup.connect() method to return the mocked connection
        when(Jsoup.connect(anyString())).thenReturn(mockConnection);

        // Stub the connection methods and response object
        when(mockConnection.get()).thenReturn(mockDocument);
        when(mockConnection.ignoreHttpErrors(true)).thenReturn(mockConnection);
        when(mockConnection.execute()).thenReturn(mockResponse);
        when(mockResponse.statusCode()).thenReturn(200);

        // Stub the document methods to return mocked headings and links
        when(mockDocument.select(anyString())).thenReturn(mockHeadings).thenReturn(mockLinks);

        // Stub the headings loop to return a single h1 element
        when(mockHeadings.iterator()).thenReturn(new ArrayList<Element>() {{
            add(new Element("h1").text("Test heading"));
        }}.iterator());

        // Stub the links loop to return a single link element
        when(mockLinks.iterator()).thenReturn(new ArrayList<Element>() {{
            add(new Element("a").attr("href", "https://example.com/valid-link"));
        }}.iterator());

        // Test the web crawler method
        Website website = webCrawler.getWebsiteHeadingsAndLinks();

        // Verify the results
        assertEquals(testUrl, website.url);
        assertEquals(1, website.headings.get("h1").size());
        assertEquals("Test heading", website.headings.get("h1").get(0));

        assertEquals(1, website.functionalLinks.size());
        assertEquals("https://example.com/valid-link", website.functionalLinks.get(0));

        assertEquals(0, website.brokenLinks.size());
    }

    @Test
    public void testBrokenLink() throws IOException {
        // Mock the Jsoup connection and document objects
        Connection mockConnection = Mockito.mock(Connection.class);
        Connection.Response mockResponse = Mockito.mock(Connection.Response.class);
        Document mockDocument = Mockito.mock(Document.class);
        Elements mockHeadings = Mockito.mock(Elements.class);
        Elements mockLinks = Mockito.mock(Elements.class);

        // Stub the Jsoup.connect() method to return the mocked connection
        when(Jsoup.connect(anyString())).thenReturn(mockConnection);

        // Stub the connection methods and response object
        when(mockConnection.get()).thenReturn(mockDocument);
        when(mockConnection.ignoreHttpErrors(true)).thenReturn(mockConnection);
        when(mockConnection.execute()).thenReturn(mockResponse);
        when(mockResponse.statusCode()).thenReturn(404); // Return 404 status code for a broken link

        // Stub the document methods to return mocked headings and links
        when(mockDocument.select(anyString())).thenReturn(mockHeadings).thenReturn(mockLinks);

        // Stub the links loop to return a single link element
        when(mockLinks.iterator()).thenReturn(new ArrayList<Element>() {{
            add(new Element("a").attr("href", "https://example.com/broken-link"));
        }}.iterator());

        // Test the web crawler method
        Website website = webCrawler.getWebsiteHeadingsAndLinks();

        // Verify the results
        assertEquals(testUrl, website.url);
        assertEquals(0, website.functionalLinks.size());
        assertEquals(1, website.brokenLinks.size());
        assertEquals("https://example.com/broken-link", website.brokenLinks.get(0));
    }

    @Test
    public void testIOException() {
        // Mock the Jsoup connection object
        Connection mockConnection = Mockito.mock(Connection.class);

        // Stub the Jsoup.connect() method to return the mocked connection
        when(Jsoup.connect(anyString())).thenReturn(mockConnection);

        // Stub the connection method to throw an IOException // todo: surrounded by try catch ?
        try {
            when(mockConnection.get()).thenThrow(IOException.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Test the web crawler method, expecting an IOException to be thrown
        assertThrows(IOException.class, () -> webCrawler.getWebsiteHeadingsAndLinks());
    }
} */



/*
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.BeforeEach;
// import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

// import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class WebCrawlerTest {
    private WebCrawler webCrawler;
    private String testUrl = "https://example.com";

    @BeforeEach
    public void setUp() {
        webCrawler = new WebCrawler(testUrl);
    }

    @Test
    public void testGetWebsiteHeadingsAndLinks() throws IOException {
        // Mock the Jsoup connection and document objects
        Connection mockConnection = Mockito.mock(Connection.class);
        Connection.Response mockResponse = Mockito.mock(Connection.Response.class);
        Document mockDocument = Mockito.mock(Document.class);
        Elements mockHeadings = Mockito.mock(Elements.class);
        Elements mockLinks = Mockito.mock(Elements.class);

        // Stub the Jsoup.connect() method to return the mocked connection
        when(Jsoup.connect(anyString())).thenReturn(mockConnection);

        // Stub the connection methods and response object
        when(mockConnection.get()).thenReturn(mockDocument);
        when(mockConnection.ignoreHttpErrors(true)).thenReturn(mockConnection);
        when(mockConnection.execute()).thenReturn(mockResponse);
        when(mockResponse.statusCode()).thenReturn(200);

        // Stub the document methods to return mocked headings and links
        when(mockDocument.select(anyString())).thenReturn(mockHeadings).thenReturn(mockLinks);

        // Stub the headings loop to return a single h1 element
        when(mockHeadings.iterator()).thenReturn(new ArrayList<Element>() {{
            add(new Element("h1").text("Test heading"));
        }}.iterator());

        // Stub the links loop to return a single link element
        when(mockLinks.iterator()).thenReturn(new ArrayList<Element>() {{
            add(new Element("a").attr("href", "https://example.com/valid-link"));
        }}.iterator());

        // Test the web crawler method
        Website website = webCrawler.getWebsiteHeadingsAndLinks();

        // Verify the results
        assertEquals(testUrl, website.url);
        assertEquals(1, website.headings.get("h1").size());
        assertEquals("Test heading", website.headings.get("h1").get(0));

        assertEquals(1, website.functionalLinks.size());
        assertEquals("https://example.com/valid-link", website.functionalLinks.get(0));

        assertEquals(0, website.brokenLinks.size());
    }

    @Test
    public void testBrokenLink() throws IOException {
        // Mock the Jsoup connection and document objects
        Connection mockConnection = Mockito.mock(Connection.class);
        Connection.Response mockResponse = Mockito.mock(Connection.Response.class);
        Document mockDocument = Mockito.mock(Document.class);
        Elements mockHeadings = Mockito.mock(Elements.class);
        Elements mockLinks = Mockito.mock(Elements.class);

        // Stub the Jsoup.connect() method to return the mocked connection
        when(Jsoup.connect(anyString())).thenReturn(mockConnection);

        // Stub the connection methods and response object
        when(mockConnection.get()).thenReturn(mockDocument);
        when(mockConnection.ignoreHttpErrors(true)).thenReturn(mockConnection);
        when(mockConnection.execute()).thenReturn(mockResponse);
        when(mockResponse.statusCode()).thenReturn(404); // Return 404 status code for a broken link

        // Stub the document methods to return mocked headings and links
        when(mockDocument.select(anyString())).thenReturn(mockHeadings).thenReturn(mockLinks);

        // Stub the links loop to return a single link element
        when(mockLinks.iterator()).thenReturn(new
                when(mockLinks.iterator()).thenReturn(new ArrayList<Element>() {{
            add(new Element("a").attr("href", "https://example.com/broken-link"));
        }}.iterator());

        // Test the web crawler method
        Website website = webCrawler.getWebsiteHeadingsAndLinks();

        // Verify the results
        assertEquals(testUrl, website.url);
        assertEquals(0, website.functionalLinks.size());
        assertEquals(1, website.brokenLinks.size());
        assertEquals("https://example.com/broken-link", website.brokenLinks.get(0));
    }

    @Test(expected = IOException.class)
    public void testIOException() throws IOException {
        // Mock the Jsoup connection object
        Connection mockConnection = Mockito.mock(Connection.class);

        // Stub the Jsoup.connect() method to return the mocked connection
        when(Jsoup.connect(anyString())).thenReturn(mockConnection);

        // Stub the connection method to throw an IOException
        when(mockConnection.get()).thenThrow(IOException.class);

        // Test the web crawler method, expecting an IOException to be thrown
        webCrawler.getWebsiteHeadingsAndLinks();
    }
} */



/*
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class WebCrawlerTest {

    @Test
    void getWebsiteHeadingsAndLinksTest() {
        WebCrawler webCrawler = new WebCrawler("https://javatpoint.com");
    } */

    /*
    private WebCrawler webCrawler;
    private String testUrl;

    @Test
    public void testGetWebsiteHeadingsAndLinks() throws IOException {
        testUrl = "https://example.com";
        webCrawler = new WebCrawler(testUrl);

        // Mock Jsoup behavior
        Document mockDocument = Mockito.mock(Document.class);
        Connection mockConnection = Mockito.mock(Connection.class);
        Connection mockConnectionWithUrl = Mockito.mock(Connection.class);
        Connection.Response mockResponse = Mockito.mock(Connection.Response.class);

        doReturn(mockConnectionWithUrl).when(mockConnection).url(eq(testUrl));
        doReturn(mockDocument).when(mockConnectionWithUrl).get();
        doReturn(mockConnectionWithUrl).when(mockConnection).url(eq("https://example.com/link"));
        doReturn(mockResponse).when(mockConnectionWithUrl).ignoreHttpErrors(true).execute();
        doReturn(200).when(mockResponse).statusCode();

        // doReturn(mockConnectionWithUrl).when(mockConnection).url(eq(testUrl));
        // doReturn(mockDocument).when(mockConnectionWithUrl).get();

        // Jsoup.connect = mockConnection;


        // when(Jsoup.connect(eq(testUrl)).get()).thenReturn(mockDocument);
        // when(Jsoup.connect(eq("https://example.com/link")).ignoreHttpErrors(true).execute().statusCode()).thenReturn(200);


        // Mock headings
        Elements mockHeadings = new Elements();
        for (int i = 1; i <= 6; i++) {
            Element mockHeading = Mockito.mock(Element.class);
            when(mockHeading.text()).thenReturn("Heading " + i);
            mockHeadings.add(mockHeading);
        }
        for (int i = 1; i <= 6; i++) {
            when(mockDocument.select("h" + i)).thenReturn(mockHeadings);
        }

        // Mock links
        Elements mockLinks = new Elements();
        Element mockLink = Mockito.mock(Element.class);
        when(mockLink.absUrl("href")).thenReturn("https://example.com/link");
        mockLinks.add(mockLink);
        when(mockDocument.select("a[href]")).thenReturn(mockLinks);

        // Mock link status code
        when(Jsoup.connect(any(String.class)).ignoreHttpErrors(true).execute().statusCode()).thenReturn(200);

        // Run test
        Website website = webCrawler.getWebsiteHeadingsAndLinks();

        // Assert results
        assertEquals(testUrl, website.url);
        assertEquals(6, website.headings.size());
        assertTrue(website.headings.contains("Heading 1"));
        assertTrue(website.headings.contains("Heading 2"));
        assertTrue(website.headings.contains("Heading 3"));
        assertTrue(website.headings.contains("Heading 4"));
        assertTrue(website.headings.contains("Heading 5"));
        assertTrue(website.headings.contains("Heading 6"));
        assertEquals(1, website.functionalLinks.size());
        assertTrue(website.functionalLinks.contains("https://example.com/link"));
        assertTrue(website.brokenLinks.isEmpty());
    }
} */
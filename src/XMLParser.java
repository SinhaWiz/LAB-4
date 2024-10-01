import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class XMLParser implements FileParser {
    @Override
    public List<Book> parseFile(String fileName) throws Exception {
        List<Book> books = new ArrayList<>();
        File xmlFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element bookElement = (Element) node;
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                int pages = Integer.parseInt(bookElement.getElementsByTagName("pages").item(0).getTextContent());
                String dateRead = bookElement.getElementsByTagName("date_read").item(0).getTextContent();
                books.add(new Book(title, author, pages,genre, dateRead));
            }
        }
        return books;
    }
}

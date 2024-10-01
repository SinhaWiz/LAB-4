import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class JSONParser implements FileParser {
    @Override
    public List<Book> parseFile(String fileName) throws Exception {
        List<Book> books = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        reader.close();
        String json = jsonBuilder.toString().trim();
        json = json.substring(1, json.length() - 1).trim();
        String[] entries = json.split("},\\s*\\{");
        for (String entry : entries) {
            entry = entry.replaceAll("[\\[\\]{}\"]", "").trim();
            String[] keyValuePairs = entry.split(",");
            String title = null;
            String author = null;
            String genre = null;
            int pages = 0;
            String dateRead = null;
            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                    case "title":
                        title = value;
                        break;
                    case "author":
                        author = value;
                        break;
                    case "genre":
                        genre = value;
                        break;
                    case "pages":
                        pages = Integer.parseInt(value);
                        break;
                    case "date_read":
                        dateRead = value;
                        break;
                }
            }
            if (title != null && author != null && genre != null && pages > 0 && dateRead != null) {
                books.add(new Book(title, author,  pages,genre, dateRead));
            } else {
                throw new IllegalArgumentException("Malformed JSON entry found: " + entry);
            }
        }
        return books;
    }
}

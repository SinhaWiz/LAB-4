import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\sinha\\IdeaProjects\\LAB_4\\Book.xml";
            String fileType = "xml";
            FileParser parser = ParserFactory.getParser(fileType);
            List<Book> books = parser.parseFile(fileName);
            System.out.println("Total Books Read: " + books.size());
            analyzeBooks(books);
        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void analyzeBooks(List<Book> books) {
        System.out.println("Analyzing Books...");
        int totalBooksLastYear = BookAnalyzer.calculateTotalBooksLastYear(books);
        System.out.println("Total Books Read Last Year: " + totalBooksLastYear);
        Map<String, Integer> booksPerMonth = BookAnalyzer.calculateBooksPerMonth(books);
        System.out.println("Books Per Month:");
        for (Map.Entry<String, Integer> entry : booksPerMonth.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " books");
        }
        List<Book> topLongestBooks = BookAnalyzer.getTopLongestBooks(books, 10);
        System.out.println("Top 10 Longest Books:");
        for (Book book : topLongestBooks) {
            System.out.println(book.getTitle() + " - " + book.getPages() + " pages");
        }
        String mostReadGenre = BookAnalyzer.getMostReadGenre(books);
        System.out.println("Most Read Genre: " + mostReadGenre);
        double averageBookLength = BookAnalyzer.calculateAverageBookLength(books);
        System.out.println("Average Book Length: " + averageBookLength + " pages");
    }
}



import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.stream.Collectors;
public class BookAnalyzer {
    public static int calculateTotalBooksLastYear(List<Book> books) {
        return books.size();
    }
    public static Map<String, Integer> calculateBooksPerMonth(List<Book> books) {
        Map<String, Integer> booksPerMonth = new HashMap<>();
        for (Book book : books) {
            String month = book.getDateRead().substring(0, 7);
            booksPerMonth.put(month, booksPerMonth.getOrDefault(month, 0) + 1);
        }
        return booksPerMonth;
    }
    public static List<Book> getTopLongestBooks(List<Book> books, int topN) {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPages).reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }
    public static String getMostReadGenre(List<Book> books) {
        Map<String, Long> genreCount = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
        return genreCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }
    public static double calculateAverageBookLength(List<Book> books) {
        return books.stream()
                .mapToInt(Book::getPages)
                .average()
                .orElse(0.0);
    }
}

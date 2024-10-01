public class Book {
    private String title;
    private String author;
    private int pages;
    private String genre;
    private String dateRead;
    public Book(String title, String author, int pages, String genre, String dateRead) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = String.valueOf(genre);
        this.dateRead = dateRead;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public String getGenre() {
        return genre;
    }
    public String getDataRead() {
        return dateRead;
    }
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", dateRead='" + dateRead + '\'' +
                '}';
    }

    public String getDateRead() {
        return dateRead;
    }
}

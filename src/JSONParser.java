import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser implements FileParser {
    @Override
    public List<Book> parseFile(String fileName) throws IOException {
        List<Book> books = new ArrayList<Book>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while((line=br.readLine())!= null){
            String [] values = line.split(",");
            Book book = new Book(values[0],values[1],Integer.parseInt(values[2]),values[3],values[4] );
            books.add(book);
        }
        br.close();
        return books;
    }
}

package pl.janusz.greencroft.isbntools;

/**
 * Created by Janusz Kacki on 18/10/2019. Project; bielmarcus
 */
public class StockManager {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService database;

    public void setWebService(ExternalISBNDataService webService) {

        this.webService = webService;
    }

    public void setDatabase(ExternalISBNDataService database) {
                                                    
        this.database = database;
    }

    public String getLocatorCode(String isbn) {

        Book book = database.lookup(isbn);
        if (book == null) {
            book = webService.lookup(isbn);
        }
        
        String author = book.getAuthor();
        String isbnStr = book.getIsbn();
        String title = book.getTitle();

        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder
                .append(isbn.substring(isbn.length() - 4, isbn.length()))
                .append(author.substring(0, 1))
                .append(title.split(" ").length)
                .toString();
    }
}

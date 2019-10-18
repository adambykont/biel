package pl.janusz.greencroft.isbntools;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 18/10/2019. Project; bielmarcus
 */
public class StockManagerTest {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService database;

    private String isbn;
    private String isbnExternal;
    private StockManager stockManager;
    private String validResponse;
    private String validResponseExternal;
    private Book book;
    private Book bookExternal;
    private ExternalISBNDataService mockDatabase;
    private ExternalISBNDataService mockWebService;

    @Test
    public void shouldUseDatabaseIfDataIsPresent() {

        String locatorCode = stockManager.getLocatorCode(isbn);

        Mockito
                .verify(mockDatabase, Mockito.times(1))
                .lookup(isbn);
        Mockito
                .verify(mockWebService, Mockito.times(0))
                .lookup(isbn);
    }

    @Test
    public void shouldUseWebServiceIfDataIsNotPresent() {

        String locatorCode = stockManager.getLocatorCode(isbnExternal);

        Mockito
                .verify(mockDatabase, Mockito.times(1))
                .lookup(isbnExternal);

        Mockito
                .verify(mockWebService, Mockito.times(1))
                .lookup(isbnExternal);
    }

    @Before
    public void setUp() throws Exception {

        isbn = "0140177396";
        isbnExternal = "1234567890";
        validResponse = "7396J4";
        validResponseExternal = "7890T1";

        stockManager = new StockManager();
        book = new Book(isbn, "Of Mice and Men", "J. Steinbeck");
        bookExternal = new Book(isbnExternal, "Algorithms", "T. Cormen");

        mockDatabase = Mockito.mock(ExternalISBNDataService.class);
        mockWebService = Mockito.mock(ExternalISBNDataService.class);

        Mockito
                .when(mockDatabase.lookup(isbn))
                .thenReturn(book);

        Mockito
                .when(mockDatabase.lookup(isbnExternal))
                .thenReturn(null);

        Mockito
                .when(mockWebService.lookup(isbn))
                .thenReturn(null);

        Mockito
                .when(mockWebService.lookup(isbnExternal))
                .thenReturn(bookExternal);

        stockManager.setDatabase(mockDatabase);
        stockManager.setWebService(mockWebService);
    }

    @Test
    public void shouldGetCorrectLocatorCode() {

        String locatorCode = stockManager.getLocatorCode(isbn);

        assertThat(locatorCode, is(equalTo(validResponse)));
    }

    @Test
    public void shouldGetAnotherLocatorCode() {

        String locatorCode = stockManager.getLocatorCode(isbnExternal);
        assertThat(locatorCode, is(equalTo(validResponseExternal)));
    }
}
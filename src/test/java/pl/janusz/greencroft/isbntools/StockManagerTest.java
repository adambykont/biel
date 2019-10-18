package pl.janusz.greencroft.isbntools;

import org.junit.Before;
import org.junit.Test;
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
    private StockManager stockManager;
    private String validResponse;

    @Test
    public void shouldUseDatabaseIfDataIsPresent() {

        ExternalISBNDataService mockDatabase = Mockito.mock(ExternalISBNDataService.class);
        stockManager.setDatabase(mockDatabase);
        String locatorCode = stockManager.getLocatorCode(isbn);

        assertThat(locatorCode, is(equalTo(validResponse)));
    }

    @Test
    public void shouldUseWebServiceIfDataIsNotPresent() {

        ExternalISBNDataService mockWebService = Mockito.mock(ExternalISBNDataService.class);
    }

    @Before
    public void setUp() throws Exception {

        isbn = "0140177396";
        validResponse = "7396J4";

        stockManager = new StockManager();

        webService = new ExternalISBNDataService() {

            @Override
            public Book lookup(String isbn) {

                return new Book(isbn, "Of Mice and Men", "J. Steinbeck");
            }
        };

        database = new ExternalISBNDataService() {

            @Override
            public Book lookup(String isbn) {

                return null;
            }
        };

//        stockManager.setDatabase(database);
//        stockManager.setWebService(webService);
    }

    @Test
    public void shouldgetCorrectLocatorCode() {

        String locatorCode = stockManager.getLocatorCode(isbn);

        assertThat(locatorCode, is(equalTo(validResponse)));
    }
}
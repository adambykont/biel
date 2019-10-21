package pl.janusz.frieze.junitdepth;

import org.hamcrest.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class ManyWaysFileReadWriteTest {

    private Path filePath;
    private Path dirPath;
    private String text;

    @Before
    public void setUp() throws Exception {

        setUpFile();

        text = "In Xanadu did Kubla Khan\n" +
                "A stately pleasure-dome decree:\n" +
                "Where Alph, the sacred river, ran\n" +
                "Through caverns measureless to man\n" +
                "Down to a sunless sea.";
    }

    private void setUpFile() throws IOException {

        String name = "xanadu.txt";
        dirPath = Paths.get("src", "test", "resources");
        dirPath.toFile().mkdir();
        filePath = dirPath.resolve(Paths.get(name));
        filePath.toFile().createNewFile();
        System.out.println(filePath.toFile().getAbsolutePath());
    }

    @Test
    public void canReadWhatHasBeenWritten() throws Exception {

        try (FileInputStream inputStream = new FileInputStream(filePath.toFile());
             FileOutputStream outputStream = new FileOutputStream(filePath.toFile())
        ) {
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                outputStream.write(c);
            }
            final StringBuilder builder = new StringBuilder();
            int c;
            while ((c = inputStream.read()) != -1) {
                builder.append((char) c);
            }
            assertThat(builder.toString(), is(equalTo(text)));
        }
    }

    @Test
    public void fileExists() {

        assertThat(dirPath.toFile().isDirectory(), is(true));
        System.out.println(dirPath.toFile().getAbsolutePath());
        assertThat(filePath.toFile().exists(), is(true));
    }

    @After
    public void tearDown() throws Exception {

        cleanUpDirectory();
    }

    private void cleanUpDirectory() {

        filePath.toFile().delete();
        dirPath.toFile().delete();
    }
}
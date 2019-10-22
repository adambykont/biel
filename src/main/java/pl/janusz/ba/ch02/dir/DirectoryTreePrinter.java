package pl.janusz.ba.ch02.dir;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class DirectoryTreePrinter {

    private final static String DELIMITER = "    ";

    public static void main(String[] args) {

        printDirectory(Paths.get("src", "test", "java", "pl", "janusz"));
    }

    public static void printDirectory(Path path) {

        printRec(path.toFile(), 0);
    }

    private static void printRec(File file, int depthMultiplier) {

        if (file.isFile()) {
            System.out.println(buildDelimiter(depthMultiplier) + file.getName());
        } else {
            System.out.println(buildDelimiter(depthMultiplier) + file.getName() + "/");
            final File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printRec(f, depthMultiplier + 1);
                }
            }
        }
    }

    private static String buildDelimiter(int depthMultiplier) {

        final StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < depthMultiplier; i++) {
            stringBuilder.append(DELIMITER);
        }

        return stringBuilder.toString();
    }
}

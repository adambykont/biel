package pl.janusz.frieze.basics;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Janusz Kacki on 19/10/2019. Project; bielmarcus
 */
public class WordCounter {

    private Set<String> words = new HashSet<>();

    public void add(String sentence) {

        if (!sentence.isEmpty()) {
            String[] temp = sentence
                    .trim()
                    .toLowerCase()
                    .split("(\\s|[',:.;])+");
            for (String s : temp) {
                words.add(s);
            }
        }
    }

    public int getUniqueWordsCount() {

        return words.size();
    }
}

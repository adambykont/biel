package pl.janusz.frieze.mockbasics.client;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */

import pl.janusz.frieze.mockbasics.article.Article;

/**
 * A target for related articles
 */
public interface Channel {

    /**
     * Call this to send an article to its destination
     * @param article the article to send
     */
    void accept(Article article);
}

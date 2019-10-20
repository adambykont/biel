package pl.janusz.frieze.mockbasics.client;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */

import pl.janusz.frieze.mockbasics.article.Article;

/**
 * A target for related articles
 */
public interface SportChannel extends Channel {

    @Override
    void accept(Article article);
}

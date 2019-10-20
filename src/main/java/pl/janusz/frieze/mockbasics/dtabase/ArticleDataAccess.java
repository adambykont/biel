package pl.janusz.frieze.mockbasics.dtabase;

import pl.janusz.frieze.mockbasics.article.Article;

import java.util.List;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */

public interface ArticleDataAccess {

    /**
     * 
     * @return all the articles from today
     */
    List<Article> getTodaysArticles();
}

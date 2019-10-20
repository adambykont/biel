package pl.janusz.frieze.mockbasics.sender;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */

import pl.janusz.frieze.mockbasics.article.Article;
import pl.janusz.frieze.mockbasics.client.Channel;
import pl.janusz.frieze.mockbasics.dtabase.ArticleDataAccess;

/**
 * Work througs today's articles sending them out to right places
 */
public class ArticleDistributor {

    private final Channel sport;
    private final Channel entertainment;
    private final Channel other;
    private final ArticleDataAccess dataAccess;

    public ArticleDistributor(Channel sport, Channel entertainment, Channel other, ArticleDataAccess dataAccess) {

        this.sport = sport;
        this.entertainment = entertainment;
        this.other = other;
        this.dataAccess = dataAccess;
    }

    public void distributeTodays() {

        for (Article article : dataAccess.getTodaysArticles()) {
            switch (article.getType()) {
                case SPORT:
                    sport.accept(article);
                    break;
                case POLITICS:
                case FINANCE:
                    other.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
            }
        }
    }
}

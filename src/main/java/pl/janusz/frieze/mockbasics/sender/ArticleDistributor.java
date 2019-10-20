package pl.janusz.frieze.mockbasics.sender;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */

import pl.janusz.frieze.mockbasics.article.Article;
import pl.janusz.frieze.mockbasics.client.Channel;
import pl.janusz.frieze.mockbasics.client.EntertainmentChannel;
import pl.janusz.frieze.mockbasics.client.OtherChannel;
import pl.janusz.frieze.mockbasics.client.SportChannel;
import pl.janusz.frieze.mockbasics.dtabase.ArticleDataAccess;

/**
 * Work througs today's articles sending them out to right places
 */
public class ArticleDistributor {

    private final SportChannel sport;
    private final EntertainmentChannel entertainment;
    private final OtherChannel other;
    private final ArticleDataAccess dataAccess;

    public ArticleDistributor(SportChannel sport,
                              EntertainmentChannel entertainment,
                              OtherChannel other,
                              ArticleDataAccess dataAccess) {

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

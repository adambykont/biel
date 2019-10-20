package pl.janusz.frieze.mockbasics.sender;

import org.junit.Test;
import org.mockito.Mockito;
import pl.janusz.frieze.mockbasics.article.Article;
import pl.janusz.frieze.mockbasics.article.Type;
import pl.janusz.frieze.mockbasics.client.Channel;
import pl.janusz.frieze.mockbasics.dtabase.ArticleDataAccess;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */
public class ArticleDistributorTest {

    @Test
    public void sportGoeToSportPoliticsToOther() {

        Channel sport = Mockito.mock(Channel.class);
        Channel entertainment = Mockito.mock(Channel.class);
        Channel other = Mockito.mock(Channel.class);

        ArticleDataAccess dataAccess = Mockito.mock(ArticleDataAccess.class);

        ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, other, dataAccess);

//        given this list of articles is returned from database
        List<Article> list = Arrays.asList(
                new Article("Sport is Fun", Type.SPORT),
                new Article("Politics is sad", Type.POLITICS));

        Mockito
                .when(dataAccess.getTodaysArticles())
                .thenReturn(list);

//        when we distribute
        distributor.distributeTodays();

//        then one goes to sport and one goes to other

        Mockito
                .verify(sport)
                .accept(Mockito.any());

        Mockito
                .verify(entertainment, Mockito.never())
                .accept(Mockito.any());

        Mockito
                .verify(other)
                .accept(Mockito.any());
    }
}
package pl.janusz.frieze.mockbasics.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.janusz.frieze.mockbasics.article.Article;
import pl.janusz.frieze.mockbasics.article.Type;
import pl.janusz.frieze.mockbasics.client.Channel;
import pl.janusz.frieze.mockbasics.client.EntertainmentChannel;
import pl.janusz.frieze.mockbasics.client.OtherChannel;
import pl.janusz.frieze.mockbasics.client.SportChannel;
import pl.janusz.frieze.mockbasics.dtabase.ArticleDataAccess;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {

    @Mock
    private SportChannel sport;
    @Mock
    private EntertainmentChannel entertainment;
    @Mock
    private OtherChannel other;
    @Mock
    private ArticleDataAccess dataAccess;

    @InjectMocks
    private ArticleDistributor distributor;

    @Test
    public void sportGoeToSportPoliticsToOther() {

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
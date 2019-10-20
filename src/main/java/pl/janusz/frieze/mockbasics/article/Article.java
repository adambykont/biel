package pl.janusz.frieze.mockbasics.article;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */

/**
 * an article a client may be interested in
 */
public class Article {

    private String content;
    private Type type;

    public Article(String content, Type type) {

        this.content = content;
        this.type = type;
    }

    public String getContent() {

        return content;
    }

    public Type getType() {

        return type;
    }
}

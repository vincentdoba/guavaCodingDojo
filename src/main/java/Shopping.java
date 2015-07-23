import com.google.common.collect.Lists;

import java.util.List;

public class Shopping {

  private List<Article> articles;

  public Shopping() {
    this.articles = Lists.newArrayList();
    articles.add(new Article("Boeuf", 12.3, 0, "Viandes", 10, 1));
    articles.add(new Article("Porc", 7.99, 5, "Viandes", 10, 1));
    articles.add(new Article("Sauce Tomate", 2, 0, "Conserves", 10, 3));
    articles.add(new Article("Petits Pois", 3.5, 10, "Conserves", 10, 2));
    articles.add(new Article("Thon", 1.50, 0, "Conserves", 20, 3));
  }

  public Shopping(List<Article> articles) {
    this.articles = articles;
  }

  public List<Article> getArticles() {
    return articles;
  }
}

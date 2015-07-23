import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ClassicAccountancy implements Accountancy {

  private Shopping shopping;

  public ClassicAccountancy(Shopping shopping) {
    this.shopping = shopping;
  }

  public double totalInvoice() {
    double total = 0;
    for (Article article : shopping.getArticles()) {
      total += article.getPriceWithoutCut() * (1 - article.getCutPercentage()/100);
    }
    return (new BigDecimal(total)).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
  }

  public double totalFor(String category) {
    double total = 0;
    for (Article article : shopping.getArticles()) {
      if (category.equals(article.getCategory())) {
        total += article.getPriceWithoutCut() * (1 - article.getCutPercentage()/100);
      }
    }
    return total;
  }

  public Map<String, Double> priceByCategory() {
    Map<String, Double> result = new HashMap<String, Double>();
    for (Article article : shopping.getArticles()) {
      Double total = result.get(article.getCategory());
      if (total == null) {
        result.put(article.getCategory(), article.getPriceWithoutCut() * (1 - article.getCutPercentage()/100));
      } else {
        result.put(article.getCategory(), total + article.getPriceWithoutCut() * (1 - article.getCutPercentage()/100));
      }
    }
    return result;
  }

  public double totalVat() {
    double total = 0;
    for (Article article : shopping.getArticles()) {
      total += article.getPriceWithoutCut() * (1 - article.getCutPercentage()/100) * (article.getVatPercentage()/100);
    }
    return total;
  }

  public double totalCut() {
    double total = 0;
    for (Article article : shopping.getArticles()) {
      if (article.getCutPercentage() > 0) {
        total += article.getPriceWithoutCut() * article.getCutPercentage()/100;
      }
    }
    return total;
  }

  public String allArticleNames() {
    StringBuilder builder = new StringBuilder();

    int index = 0;
    for (Article article : shopping.getArticles()) {
      builder.append(article.getName());
      if (index != shopping.getArticles().size() - 1) {
        builder.append(", \n");
      }
      index++;

    }
    return builder.toString();
  }
}

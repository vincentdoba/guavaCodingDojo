import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAccountancy implements Accountancy {


  private Shopping shopping;

  public StreamAccountancy(Shopping shopping) {
    this.shopping = shopping;
  }

  @Override
  public double totalInvoice() {
    return shopping.getArticles().parallelStream()
            .map(StreamAccountancy::computePrice)
            .reduce((a, b) -> a + b)
            .map(StreamAccountancy::getRoundedPrice)
            .get();

  }

  @Override
  public double totalFor(String category) {
    return shopping.getArticles().parallelStream()
            .filter(x -> category.equals(x.getCategory()))
            .map(StreamAccountancy::computePrice)
            .reduce((a, b) -> a + b)
            .map(StreamAccountancy::getRoundedPrice)
            .get();

  }

  @Override
  public Map<String, Double> priceByCategory() {
    return null;
  }


  @Override
  public double totalVat() {
    return shopping.getArticles().parallelStream()
            .map(StreamAccountancy::computeVat)
            .reduce((a, b) -> a + b)
            .map(StreamAccountancy::getRoundedPrice)
            .get();
  }

  @Override
  public double totalCut() {
    return shopping.getArticles().parallelStream()
            .map(StreamAccountancy::computeCut)
            .reduce((a, b) -> a + b)
            .map(StreamAccountancy::getRoundedPrice)
            .get();
  }

  @Override
  public String allArticleNames() {
    return shopping.getArticles().parallelStream().map(Article::getName).collect(Collectors.joining(",\n"));
  }

  @Override
  public List<String> topIngredientList(int i) {
    return shopping.getArticles().parallelStream()
            .flatMap(x -> x.getIngredients().stream())
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
            .entrySet()
            .parallelStream()
            .sorted((a, b) -> b.getValue().intValue() - a.getValue().intValue())
            .map(Map.Entry::getKey)
            .limit(i)
            .collect(Collectors.toList());
  }

  private static double computePrice(Article article) {
    return article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100);
  }

  private static double computeVat(Article article) {
    return article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100) * (article.getVatPercentage() / 100);
  }

  private static double computeCut(Article article) {
    return article.getPriceWithoutCut() * article.getCutPercentage() / 100;
  }


  private static double getRoundedPrice(double total) {
    return (new BigDecimal(total)).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
  }
}

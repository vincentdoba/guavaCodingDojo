import java.util.Map;

public interface Accountancy {

  double totalInvoice();
  double totalFor(String category);
  Map<String, Double> priceByCategory();
  double totalVat();
  double totalCut();
  String allArticleNames();
}

import java.util.List;
import java.util.Map;

public interface Accountancy {

  double totalInvoice();
  double totalFor(String category);
  Map<String, Double> priceByCategory();
  double totalVat();
  double totalCut();
  String allArticleNames();

    List<String> topIngredientList(int i);
}

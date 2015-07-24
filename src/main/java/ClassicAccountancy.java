
import java.math.BigDecimal;
import java.util.*;

public class ClassicAccountancy implements Accountancy {

    private Shopping shopping;

    public ClassicAccountancy(Shopping shopping) {
        this.shopping = shopping;
    }

    public double totalInvoice() {
        double total = 0;
        for (Article article : shopping.getArticles()) {
            total += article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100);
        }
        return getRoundedPrice(total);
    }

    public double totalFor(String category) {
        double total = 0;
        for (Article article : shopping.getArticles()) {
            if (category.equals(article.getCategory())) {
                total += article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100);
            }
        }
        return getRoundedPrice(total);
    }

    public Map<String, Double> priceByCategory() {
        Map<String, Double> result = new HashMap<>();
        for (Article article : shopping.getArticles()) {
            Double total = result.get(article.getCategory());
            if (total == null) {
                double amount = article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100);
                result.put(article.getCategory(), getRoundedPrice(amount));
            } else {
                double amount = total + article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100);
                result.put(article.getCategory(), getRoundedPrice(amount));
            }
        }
        return result;
    }

    public double totalVat() {
        double total = 0;
        for (Article article : shopping.getArticles()) {
            total += article.getPriceWithoutCut() * (1 - article.getCutPercentage() / 100) * (article.getVatPercentage() / 100);
        }
        return getRoundedPrice(total);
    }

    public double totalCut() {
        double total = 0;
        for (Article article : shopping.getArticles()) {
            if (article.getCutPercentage() > 0) {
                total += article.getPriceWithoutCut() * article.getCutPercentage() / 100;
            }
        }
        return getRoundedPrice(total);
    }

    public String allArticleNames() {
        StringBuilder builder = new StringBuilder();

        int index = 0;
        for (Article article : shopping.getArticles()) {
            builder.append(article.getName());
            if (index != shopping.getArticles().size() - 1) {
                builder.append(",\n");
            }
            index++;

        }
        return builder.toString();
    }

    public List<String> topIngredientList(int i) {

        Map<String, Integer> countByIngredient = new HashMap<>();
        for (Article article : shopping.getArticles()) {
            for (String ingredient : article.getIngredients()) {
                Integer count = countByIngredient.get(ingredient);
                if (count == null) {
                    countByIngredient.put(ingredient, 1);
                } else {
                    countByIngredient.put(ingredient, count + 1);
                }
            }
        }

        Iterator<String> iterator = countByIngredient.keySet().iterator();
        List<String> topIngredients = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer count = countByIngredient.get(key);

            if (topIngredients.size() < i) {
                topIngredients.add(key);
            } else {
                int j = 0;
                for (String topIngredient : topIngredients) {
                    if (count > countByIngredient.get(topIngredient)) {
                        topIngredients.set(j, key);
                        break;
                    }
                    j++;
                }
            }

        }

        return topIngredients;
    }

    private double getRoundedPrice(double total) {
        return (new BigDecimal(total)).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }
}

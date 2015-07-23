import java.util.Map;

public class GuavaAccountacy implements Accountancy {

    private Shopping shopping;

    public GuavaAccountacy(Shopping shopping) {

        this.shopping = shopping;
    }

    @Override
    public double totalInvoice() {
        return 0;
    }

    @Override
    public double totalFor(String category) {
        return 0;
    }

    @Override
    public Map<String, Double> priceByCategory() {
        return null;
    }

    @Override
    public double totalVat() {
        return 0;
    }

    @Override
    public double totalCut() {
        return 0;
    }

    @Override
    public String allArticleNames() {
        return null;
    }
}

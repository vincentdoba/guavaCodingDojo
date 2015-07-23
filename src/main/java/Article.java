public class Article {

  private String name;
  private double priceWithoutCut;
  private double cutPercentage;
  private String category;
  private double vatPercentage;
  private int quantity;

  public Article(String name, double priceWithoutCut, double cutPercentage, String category, double vatPercentage, int quantity) {
    this.name = name;
    this.priceWithoutCut = priceWithoutCut;
    this.cutPercentage = cutPercentage;
    this.category = category;
    this.vatPercentage = vatPercentage;
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPriceWithoutCut() {
    return priceWithoutCut;
  }

  public void setPriceWithoutCut(double priceWithoutCut) {
    this.priceWithoutCut = priceWithoutCut;
  }

  public double getCutPercentage() {
    return cutPercentage;
  }

  public void setCutPercentage(double cutPercentage) {
    this.cutPercentage = cutPercentage;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getVatPercentage() {
    return vatPercentage;
  }

  public void setVatPercentage(double vatPercentage) {
    this.vatPercentage = vatPercentage;
  }
}

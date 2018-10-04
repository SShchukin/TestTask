public class Purchase {
  private int cardCode;
  private String shopName;
  private String purchaseName;
  private int date;
  private double cost;

  public Purchase(int cardCode, String shopName, String purchaseName, int date, double cost) {
    this.cardCode = cardCode;
    this.shopName = shopName;
    this.purchaseName = purchaseName;
    this.date = date;
    this.cost = cost;
  }

  public Purchase() {

  }

  public int getCardCode() {
    return cardCode;
  }

  public void setCardCode(int cardCode) {
    this.cardCode = cardCode;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getPurchaseName() {
    return purchaseName;
  }

  public void setPurchaseName(String purchaseName) {
    this.purchaseName = purchaseName;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public void print() {
    System.out.printf("%n%9d; %15s; %15s; %4d; %10.2f;", this.cardCode, this.shopName, this.purchaseName, this.date, this.cost);
  }
}

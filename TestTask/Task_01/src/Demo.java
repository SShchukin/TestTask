import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Demo {
  public static void main(String[] args) throws IOException {
    ArrayList<Purchase> purchases = new ArrayList<>();

    CSVReader csvReader = null;
    try {
      csvReader = new CSVReader(new FileReader(args[0]), ';');
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String[] nextRecord;

    while((nextRecord = csvReader.readNext()) != null) {
      Purchase example = new Purchase();
      example.setCardCode(Integer.parseInt(nextRecord[0]));
      example.setShopName(nextRecord[1]);
      example.setPurchaseName(nextRecord[2]);
      example.setDate(Integer.parseInt(nextRecord[3]));
      example.setCost(Double.parseDouble(nextRecord[4]));
      purchases.add(example);
    }

    System.out.printf("%10s%17s%17s%6s%12s", "КОД КАРТЫ","МАГАЗИН","ТОВАР","ДАТА","ЦЕНА");
    for(Purchase p : purchases) {
      p.print();
    }

    purchases.sort(Comparator.comparing(Purchase::getDate));
    System.out.printf("%n%n%10s%17s%17s%6s%12s", "КОД КАРТЫ","МАГАЗИН","ТОВАР","ДАТА","ЦЕНА");
    for(Purchase p : purchases) {
      p.print();
    }

    purchases.sort(Comparator.comparing(Purchase::getCardCode));
    int tempCode = purchases.get(0).getCardCode();
    double cost = 0.0;
    System.out.printf("%n%n%9s : %s", "КОД КАРТЫ", "ПОТРАЧЕНО СРЕДСТВ");
    for (Purchase p : purchases) {
      if(tempCode != p.getCardCode()) {
        System.out.printf("%n%9d : %10.2f", tempCode, cost);
        tempCode = p.getCardCode();
        cost = p.getCost();
      } else {
        cost += p.getCost();
      }
    }
    System.out.printf("%n%9d : %10.2f", tempCode, cost);

  }
}

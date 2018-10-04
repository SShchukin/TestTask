import java.util.Arrays;
import java.util.Collections;

public class Storage {
  private String data;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Storage() {
    this.data = null;
  }

  public Storage(String data) {
    this.data = data;
  }

  public void addData(String data) {
    this.data += data;
  }

  public void printData(String data) {
    System.out.println(data);
  }

  public String getSortedData(String data, String order) {
    String[] split = data.split("");
    if (order == "reverse") {
      Arrays.sort(split, Collections.reverseOrder());
    } else {
      Arrays.sort(split);
    }
    String sorted = "";

    for (int i = 0; i < split.length; i++) {
      sorted += split[i];
    }

    return sorted;
  }
}

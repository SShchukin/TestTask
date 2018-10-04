import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {
  public static void main(String[] args) {
    String string = null;
    Path path = Paths.get(args[0]);

    try {
      byte[] bytes = Files.readAllBytes(path);

      string = new String(bytes);
    } catch (IOException e) {
      System.out.println(e);
    }
    Storage storage = new Storage(string);

    //Вывод символов [0..9] в исходном порядке
    String unsortedInt = "";
    String processedStr = storage.getData();
    int length = processedStr.length();

    for (int i = 0; i < length; i++) {
      char temp = processedStr.charAt(i);
      if(temp >= '0' && temp <= '9') {
        unsortedInt += temp;
      }
    }

    System.out.println(unsortedInt);

    //Вывод символов [0..9], упорядоченных по убыванию
    System.out.println(storage.getSortedData(unsortedInt, "reverse"));

    //Вывод каждого символа не более одного раза
    String nonrepeatStr = "";
    for (int i = 0; i < length; i++) {
      char temp = processedStr.charAt(i);
      if(nonrepeatStr.indexOf(temp) == -1) {
        nonrepeatStr += temp;

      }
    }

    System.out.println(nonrepeatStr);

  }
}

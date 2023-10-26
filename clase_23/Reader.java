import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {
  public static void main(String[] args) {
    Map<Character, Integer> m = new HashMap<Character, Integer>(); 
    try {
      FileReader fileReader = new FileReader("BIBLIA_COMPLETA.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      int character;
      char c;
      while ((character = bufferedReader.read()) != -1) {
        c = (char) character;
        if (m.containsKey(c)){
            m.put(c, m.get(c) + 1);
        } else {
            m.put(c, 1);
        }
      }

      bufferedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    List<Map.Entry<Character, Integer>> list = new ArrayList<>(m.entrySet());
    
    class EntryComparator implements Comparator<Map.Entry<Character, Integer>> {
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    }
    
    Collections.sort(list, new EntryComparator());
    for (Map.Entry<Character, Integer> entry : list) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
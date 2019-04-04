import java.util.*;

public class Radix {
  public static void main(String[] args) {
    int[] data = {1, 5, 7, 2, 4, 4, 2, 0};
    System.out.println(findMaxLength(data));
    radixsort(data);
  }
  public static void radixsort(int[] data) {
    @SuppressWarnings({"unchecked", "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    int passes = findMaxLength(data);
    int idx = 0;
    while (idx < maxLength) {
      if (idx == 0) {

      }
      else {
        int bucket = 0;
        while (bucket != buckets.length) {
          if (buckets[bucket].size() == 0) bucket++;
          else {
            int myLLI = 0;
            while (myLLI < buckets[bucket].size()) {
              Integer tempI = buckets[bucket].removeFront();
              String temp = tempI + "";
              Integer digit = Integer.parseInt(temp.charAt(idx) + "");
              if (tempI < 0) {
                buckets[9 - digit].add(tempI);
              }
              else {
                buckets[10 + digit].add(tempI);
              }
            }
          }
        }
      }
      idx++;
    }
    merge(data, buckets);
  }
  private static void firstPass(int[] data, MyLinkedList<Integer> buckets) {
    for (int i = 0; i < data.length; i++) {
      String temp = data[i]+"";
      Integer digit = Integer.parseInt(temp.charAt(idx) + "");
      if (data[i] < 0) {
        buckets[9 - digit].add(data[i]);
      }
      else {
        buckets[10 + digit].add(data[i]);
      }
    }
  }
  public static int findMaxLength(int[] data) {
    if (data.length == 0) return 0;
    int returner = 0;
    int current = 0;
    for (int num:data) {
      current = Math.max(Math.abs(num), current);
    }
    while (current != 0) {
      current /= 10;
      returner++;
    }
    return returner;
  }
  public static void merge(int[] data, MyLinkedList<Integer>[] buckets) {
    int bucket = 0;
    int dI = 0;
    while (bucket < buckets.length && dI < data.length) {
      if (buckets[bucket].size() == 0) bucket++;
      else {
        int myLLI = 0;
        while (myLLI < buckets[bucket].size()) {
          Integer tempI = buckets[bucket].removeFront();
          data[dI] = tempI;
          dI++;
        }
      }
    }
  }
}

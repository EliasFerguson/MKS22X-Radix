import java.util.*;

public class Radix {
  public static void radixsort(int[] data) {
    @SuppressWarnings({"unchecked", "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int maxLength = findMaxLength(data);
  }
  public static int findMaxLength(int[] data) {
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
}

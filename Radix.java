import java.util.*;
import java.io.*;
public class Radix {
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
  public static void radixsort(int[] data) {
    @SuppressWarnings({"unchecked", "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> spare = new MyLinkedList<Integer>();
    int passes = findMaxLength(data);
    int idx = 0;
    while (idx < passes) {
      if (idx == 0) {
        firstPass(data, buckets);
      }
      else {
        pass(spare, idx, buckets);
      }
      spare.clear();
      for (int i2 = 0; i2 < buckets.length; i2++) {
        spare.extend(buckets[i2]);
      }
      idx++;
    }
    merge(data, spare);
  }
  private static void firstPass(int[] data, MyLinkedList<Integer>[] buckets) {
    for (int i = 0; i < data.length; i++) {
      int curr = data[i];
      int digit = curr % 10;
      buckets[digit+9].add(curr);
    }
  }
  private static void pass(MyLinkedList<Integer> data, int idx, MyLinkedList<Integer>[] buckets) {
    Node<Integer> curr = data.getStart();
    int val = curr.getData();
    int digit = val / (int) Math.pow(10, idx) % 10;
    buckets[digit + 9].add(val);
    while (curr.hasNext()) {
      curr = curr.next();
      val = curr.getData();
      digit = val / (int) Math.pow(10, idx) % 10;
      buckets[digit + 9].add(val);
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
  public static void merge(int[] data, MyLinkedList<Integer> spare) {
    Node<Integer> n = spare.getStart();
    data[0] = n.getData();
    int i = 1;
    while (n.hasNext()) {
      n = n.next();
      data[i] = n.getData();
      i++;
    }
  }
}

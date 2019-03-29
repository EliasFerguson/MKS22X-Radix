public class MyLinkedList<E> {
  private class Node {
    private E data;
    private Node next, prev;
    private Node(E in, Node nextIn, Node prevIn) {
      data = in;
      next = nextIn;
      prev = prevIn;
    }
    private Node next() {
      return next;
    }
    private Node prev() {
      return prev;
    }
    private void setNext(Node other) {
      next = other;
    }
    private void setPrev(Node other) {
     prev = other;
    }
    private E getData() {
      return data;
    }
    private E setData(E i) {
      E old = data;
      data = i;
      return old;
    }
    public String toString() {
      return "" + data;
    }
  }
  private int size;
  private Node start, end;
  public String toString() {
    int i = 0;
    Node curr = start;
    String output = "[";
    if (size == 0) return "[]";
    while (i < size - 1) {
      output += curr.toString() + ", ";
      curr = curr.next();
      i++;
    }
    return output + curr.toString() + "]";
  }
  public MyLinkedList() {
    size = 0;
    start = null;
    end = null;
  }
  public int size() {
    return size;
  }
  public void clear() {
    size = 0;
    start = null;
    end = null;
  }
  public void add(E in) {
    if (size == 0) {
      Node n = new Node(in, null, null);
      start = n;
      end = n;
    }
    else {
      Node n = new Node(in, end, null);
      end = n;
      n.prev().setNext(n);
    }
    size++;
  }
  public void extend(MyLinkedList<E> other) {
    Node otherStart = other.start;
    Node otherEnd = other.end;
    end.setNext(otherStart);
    otherStart.setPrev(end);
    end = otherEnd;
    size += other.size();
    MyLinkedList spare = new MyLinkedList();
    other.start = spare.start;
    other.end = spare.end;
    other.size = spare.size;
  }
  public E removeFront() {
    E returner = start.getData();
    start = start.next();
    size--;
    return returner;
  }
}

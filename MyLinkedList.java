public class MyLinkedList<E> {
  private class Node {
    private E data;
    private Node next, prev;
    private Node(E in) {
      data = in;
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

  }
  public MyLinkedList() {
    size = 0;
    start = null;
    end = null;
  }
  public void clear() {
    size = 0;
    start = null;
    end = null;
  }
  public boolean add(E in) {

  }
  public void extend(MyLinkedList<E> in) {

  }
  public E removeFront() {

  }
}

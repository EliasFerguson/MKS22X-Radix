import java.util.*;
public class MyLinkedList<E> {
  private int size;
  private Node<E> start, end;
  public String toString() {
    int i = 0;
    Node<E> curr = start;
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
      Node<E> n = new Node<E>(in, null, null);
      start = n;
      end = n;
    }
    else {
      Node<E> n = new Node<E>(in, end, null);
      end.setNext(n);
      end = n;
    }
    size++;
  }
  public Node<E> getStart() {
    return start;
  }
  public void extend(MyLinkedList<E> other) {
    if (size == 0) {
      start = other.start;
      end = other.end;
    }
    else if (other.size != 0) {
      end.setNext(other.start);
      other.start.setPrev(this.end);
      end = other.end;
    }
    size += other.size;
    other.clear();
  }
  public E iterator(Node<E> n) {
    return n.next().getData();
  }
}

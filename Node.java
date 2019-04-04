public class Node<E>{
  private E data;
  private Node<E> next, prev;
  public Node(E value, Node<E> newPrev, Node<E> newNext){
    data = value;
    next = newNext;
    prev = newPrev;
  }
  public boolean hasNext(){
    if(next == null){
      return false;
    }
    return true;
  }
  public E getData(){
    return data;
  }
  public Node<E> next(){
    return next;
  }
  public Node<E> prev(){
    return prev;
  }
  public E setData(E value){
    E output = data;
    data = value;
    return output;
  }
  public void setNext(Node<E> nextNew){
    next = nextNew;
  }
  public void setPrev(Node<E> prevNew){
    prev = prevNew;
  }
  public String toString(){
    return "" + data;
  }
}

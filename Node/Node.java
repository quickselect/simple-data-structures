package Node;
public class Node<E> {
  public E data;
  public Node<E> next = null;

  public Node (E data) {
    this.data = data;
  }
}

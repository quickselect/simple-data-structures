public class Queue<E> implements QueueInterface<E> {
  int length = 0;
  DoublyLinkedList<E> container = null;
  Node<E> head = container.first;
  Node<E> tail = null;

  public Queue(){}

  public E front() {
    return head;
  }

  public E back() {
    return tail;
  }

  public boolean empty() {
    if(length==0) return true;
    else return false;
  }

  public int size() {
    return length;
  }

  public void push(E value) {
    Node<E> new_node = new Node(value);
    tail = container.insertAfter(head, new_node);
  }

  public void pop() {
    
  }

}

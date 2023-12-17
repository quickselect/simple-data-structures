import Node.Node;

public class Queue<E> implements QueueInterface<E> {
  int length = 0;
  DoublyLinkedList<E> container = null;
  Node<E> head = null;
  Node<E> tail = null;

  public Queue(){
    this.container = new DoublyLinkedList<>();
  }

  public E front() {
    return head.data;
  }

  public E back() {
    return tail.data;
  }

  public boolean empty() {
    if(length==0) return true;
    else return false;
  }

  public int size() {
    return length;
  }

  public void push(E value) {
    if(length==0){
      container.push(value);
      head = container.head;
      tail = head;
    } else {
      container.push(value);
    }
    ++length;
    return;
  }

  public void pop() {
    Node<E> temp = tail.prev;
    container.remove(tail);
    tail = temp;
  }

  public static void main(String[] args){
    Queue<Integer> aQueue = new Queue<>();
    aQueue.push(1);
    System.out.println(aQueue.tail.data.toString());
    aQueue.push(2);
    System.out.println(aQueue.tail.data.toString());
    aQueue.push(3);
    System.out.println(aQueue.tail.data.toString());
    System.out.println(aQueue.container.toString());

    aQueue.pop();
    System.out.println(aQueue.tail.data.toString());
    System.out.println(aQueue.container.toString());
  }
}

import Node.Node;

import javax.swing.*;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Dequeue<E> implements DequeueInterface<E> {
  int size = null;
  CircularDoublyLinkedList<E> container = null;

  Dequeue<E>(){
    this.size = 0;
    this.container = new CircularDoublyLinkedList<>();
  }

  public Node<E> front() {
    if(size == 0) throw new NoSuchElementException();
    return this.container.first;
  }

  public Node<E> back() {
    if(size == 0) throw new NoSuchElementException();
    return this.container.first.prev;
  }

  public boolean isEmpty(){
    if (size == 0) return true;
    else return false;
  }

  public int size(){ return this.size;}

  public void clear() {
    this.container.deleteList();
    this.size = 0;
  }

  void push_back(E value){
    Node<E> new_node = new Node(value);
    this.container.InsertEnd(new_node);
    ++this.size;
  }

  // T(N) for both pop_back and pop_front isn't particularly efficient
  // but it's fine for now.
  void pop_back() {
    this.container.remove(this.container.first.prev);
    --this.size;
  }

  void push_front(E value){
    this.container.push(value);
    ++this.size;
  }

  void pop_front() {
    this.container.remove(this.container.first);
    --this.size;
  }

  public static void main(String[] args) {
//    Dequeue<Integer> deck = new Dequeue<>();
//    deck.isEmpty();
  }
}

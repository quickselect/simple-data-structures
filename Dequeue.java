import Node.Node;

import javax.swing.*;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Dequeue<E> implements DequeueInterface<E> {
  int size = 0;
  CircularDoublyLinkedList<E> container = null;

  Dequeue(){
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

  public void push_back(E value){
    Node<E> new_node = new Node(value);
    this.container.insertEnd(new_node);
    ++this.size;
  }

  // T(N) for both pop_back and pop_front isn't particularly efficient
  // but it's fine for now.
  public void pop_back() {
    this.container.remove(this.container.first.prev);
    --this.size;
  }

  public void push_front(E value){
    this.container.push(value);
    ++this.size;
  }

  public void pop_front() {
    this.container.remove(this.container.first);
    --this.size;
  }

  public String toString() {
    return this.container.toString();
  }

  public static void main(String[] args) {
    Dequeue<Integer> deck = new Dequeue<>();
    deck.isEmpty();
    deck.push_front(1);
    deck.push_front(2);
    deck.push_front(3);
    System.out.println(deck.toString());

    System.out.println(deck.front().data);
    deck.pop_front();
    System.out.println(deck.toString());

    System.out.println(deck.back().data);
    deck.pop_back();
    System.out.println(deck.toString());

    System.out.println(deck.front().data);

    deck.push_back(7);
    deck.push_back(8);
    deck.push_back(9);
    System.out.println(deck.toString());
  }
}

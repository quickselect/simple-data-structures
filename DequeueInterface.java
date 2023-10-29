/*
  std::deque (double-ended queue) is an indexed sequence container that allows
  fast insertion and deletion at both its beginning and its end. In addition,
  insertion and deletion at either end of a deque never invalidates pointers
  or references to the rest of the elements.

  the elements of a deque are not stored contiguously.

  The complexity (efficiency) of common operations on deques is as follows:
  Random access - constant O(1).
  Insertion or removal of elements at the end or beginning - constant O(1).
  Insertion or removal of elements - linear O(n).
 */

public interface DequeueInterface<E> {
  // MEMBER FUNCTIONS
  // assigns values to the container.
  public void assign(int count, E value);

  // ELEMENT ACCESS
  // access specified element with bounds checking.
  public Node<E> at(int pos);

  // access the first element.
  public Node<E> front();

  // access the last element.
  public Node<E> back();

  // CAPACITY
  // checks whether the container is empty.
  public boolean empty();

  // returns the number of elements.
  public int size();

  // MODIFIERS
  // clears the contents.
  public void clear();

  // inserts elements.
  void insert(int pos, E value);

  // erases elements.
  void erase(int pos);

  // adds an element to the end.
  void push_back(E value);

  // removes the last element.
  void pop_back();

  // inserts an element to the beginning.
  void push_front(E value);

  // removes the first element.
  void pop_front();

  // changes the number of elements stored.
  void resize(int count);
  void resize(int count, E value);

  // swaps the contents.
  void swap(DequeueInterface<E> other);
}

public interface DequeueInterface<E> {
  // ELEMENT ACCESS
  // access the first element.
  public Node<E> front();

  // access the last element.
  public Node<E> back();

  // CAPACITY
  // checks whether the container is empty.
  public boolean isEmpty();

  // returns the number of elements.
  public int size();

  // MODIFIERS
  // clears the contents.
  public void clear();

  // adds an element to the end.
  void push_back(E value);

  // removes the last element.
  void pop_back();

  // inserts an element to the beginning.
  void push_front(E value);

  // removes the first element.
  void pop_front();
}
import Node.Node;

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
  public void push_back(E value);

  // removes the last element.
  public void pop_back();

  // inserts an element to the beginning.
  public void push_front(E value);

  // removes the first element.
  public void pop_front();
}
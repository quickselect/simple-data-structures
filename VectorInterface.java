public interface VectorInterface<E> {
  // MEMBER FUNCTIONS
  // ELEMENT ACCESS
  // access specified element with bounds checking.
  E at(int pos);

  // access the first element.
  E front();

  // access the last element.
  E back();

  // direct access to the underlying array.
  E[] data();

  // CAPACITY
  // checks whether the container is empty.
  boolean empty();

  // returns the number of elements.
  int size();

  // returns the number of elements that can be held in currently allocated storage.
  int capacity();

  // MODIFIERS
  // clears the contents
  void clear();

  // inserts elements
  void insert(int pos, E value);

  // erases elements.
  void erase(int pos);

  // adds an element to the end.
  void push_back(E value);

  // removes the last element.
  void pop_back();

  // changes the number of elements stored.
  void resize(int count);
}
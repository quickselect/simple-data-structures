public interface Queue<E> {
  // pointer to first element.
  E front();

  // pointer to last element.
  E back();

  // checks whether the underlying container is empty.
  boolean empty();

  // returns the num of elements.
  int size();

  // inserts element at the end.
  void push(E value);
  
  // removes the first element.
  void pop();
}

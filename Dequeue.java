import Node.Node;

public class Dequeue<E> implements DequeueInterface<E> {
  int size = 0;
  DoublyLinkedList<E> container = null;
  Node<E> front = null;
  Node<E> back = null;

  public Dequeue() {
    this.container = new DoublyLinkedList<>();
  }

  // Time complexity is O(|count-size|)
  // Space complexity is O(1)
  public void assign(int count, E value) {
    int diff = 0;
    if(size < count) {
      diff = count-this.size;

      int remaining_nodes = diff;
      while(remaining_nodes != 0){
        this.push_back(value);
        --remaining_nodes;
      }
    } else {
      diff = this.size-count;

      int nodes_to_remove = diff;
      while(nodes_to_remove != 0) {
        this.pop_back();
        --nodes_to_remove;
      }
    }

    // overwriting data/s
    int nodes_to_change = this.size-diff;
    Node<E> curr = front;
    while(nodes_to_change != 0){
      curr.data = value;
      curr = curr.next;
    }

    return;
  }


}

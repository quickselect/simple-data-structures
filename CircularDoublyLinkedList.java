import Node.Node;

class CircularDoublyLinkedList<E>{
  int size = 0;
  // pointer to first node.
  Node<E> first;
  // pointer to last node.
  Node<E> last;

  public CircularDoublyLinkedList(){}

  void deleteList(){
    first = null;
    last = null;
  }

  void push(E new_data){
    Node<E> new_node = new Node(new_data);

    new_node.next = start;
    new_node.prev = last;

    last.next = first.prev = new_node;

    first = new_node;
  }

  // basically the same thing as the push method
  void append(E new_data){
    Node<E> new_node = new Node(new_data);

    new_node.next = start;
    new_node.prev = last;

    last.next=first.prev=new_node;

    last = new_node;
  }

  void InsertAfter(Node<E> prev_node, E new_data) {
    if(prev_node == null) return;

    Node<E> new_node = new Node(new_data);
    new_node.next = prev_node.next;
    prev_node.next = new_node;
    new_node.prev = prev_node;

    if(new_node.next != null) new_node.next.prev = new_node;

    // check if we've inserted after the last node, so that we can update the last Node.
    if(new_node.prev == last) last = new_node;
  }

  void InsertBefore(Node<E> next_node, E new_data){
    if(next_node == null) return;

    Node<E> new_node = new Node(new_data);
    new_node.prev = next_node.prev;
    next_node.prev = new_node;
    new_node.next = next_node;
    if(new_node.prev != null) new_node.prev.next = new_node;
    else first = new_node;
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[ ");
    Node<E> temp = head;
    if(temp==null){
      str.append("]");
      return str.toString();
    }
    do {
      str.append(temp.data.toString() + " -> ");
      temp = temp.next;
    } while(temp!=first)
    str.append("NULL ]");
    return str.toString();
  }

  static void main(String[] args) {
    CircularDoublyLinkedList<Integer> cdll = new CircularDoublyLinkedList<>();
    cdll.push(1);
    cdll.push(2);
    cdll.push(3);
    cdll.push(4);
    System.out.printl(cdll.toString());
//    cdll.reverseIteratively()
//    System.out.printl(cdll.toString());
  }

}

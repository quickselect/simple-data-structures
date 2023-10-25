import Node.Node;

class DoublyLinkedList<E> {
  Node<E> head;

  public DoublyLinkedList(){}

  void deleteList(){
    head.next = null;
    head.prev = null;
  }

  // T(1) S(1)
  void push(E new_data) {
    Node<E> new_node = new Node(new_data);

    new_node.next = head;
    new_node.prev = null;

    if(head!=null) head.prev = new_node;

    head = new_node;
  }

  // T(1) S(1)
  void InsertAfter(Node<E> prev_node, E new_data){
    if(prev_node == null) {
      return;
    }

    Node<E> new_node = new Node(new_data);
    new_node.next = prev_node.next;
    prev_node.next = new_node;
    new_node.prev = prev_node;

    if(new_node.next != null) new_node.next.prev = new_node;
  }

  // T(1) S(1)
  void InsertBefore(Node<E> next_node, E new_data){
    if(next_node == null) {
      return;
    }

    Node<E> new_node = new Node(new_data);
    new_node.prev = next_node.prev;
    next_node.prev = new_node;
    new_node.next = next_node;
    if(new_node.prev != null) new_node.prev.next = new_node;
    else head = new_node;
  }

  // T(N) S(1)
  void append(E new_data){
    Node<E> new_node = new Node(new_data);
    Node<E> last = head;
    new_node.next = null;
    if(head == null) {
      new_node.prev = null;
      head=new_node;
      return;
    }

    while(last.next!= null) last = last.next;

    last.next = new_node;
    new_node.prev = last;
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[ ");
    Node<E> temp = head;
    if(temp==null){
      str.append("]");
      return str.toString();
    }
    while(temp!=null){
//      System.out.println(temp.data);
      str.append(temp.data.toString() + " -> ");
      temp = temp.next;
    }
    str.append("NULL ]");
    return str.toString();
  }

  // T(N) S(1)
  void reverseIteratively(){
    Node<E> prev = null;
    Node<E> current = head;

    while(current!=null){
      prev = current.prev;
      current.prev = current.next;
      current.next = prev;
      current = current.prev;
    }

    if(prev!=null) head = prev.prev;
  }

  public static void main(String[] args){
    // push, insert after, insert before, append
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    dll.push(1);
    dll.push(2);
    dll.push(3);
    dll.push(4);
    System.out.println(dll.toString());
    dll.reverseIteratively();
    System.out.println(dll.toString());
  }

}
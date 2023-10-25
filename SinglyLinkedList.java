import Node.Node;

class SinglyLinkedList<E> {
  Node<E> head;

  void deleteList() { this.head = null; }

  // T(1) S(1)
  void push(E new_data){
    Node<E> new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
  }

  // T(N) S(1)
  void append(E new_data){
    Node<E> new_node = new Node(new_data);

    if(head == null) {
      head = new Node(new_data);
      return;
    }

    new_node.next = null;

    Node<E> last = head;
    while(last.next!= null) last = last.next;

    last.next = new_node;
    return;
  }

  // T(N) S(1)
  Node reverseIteratively(Node<E> node){
    Node<E> prev = null;
    Node<E> current = node;
    Node<E> next = null;
    while(current!=null){
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  // T(N) S(N), fn call stack space
  Node reverseRecursively(Node<E> head){
    if(head == null || head.next == null) return head;
    Node<E> rest = reverseRecursively(head.next);
    head.next.next=head;
    head.next=null;
    return rest;
  }

  // driver
  public static void main(String[] args) {
  }
}
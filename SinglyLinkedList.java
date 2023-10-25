import Node.Node;

class SinglyLinkedList<E> {
  Node<E> head;

  void deleteList() { this.head = null; }

  // empty list
  public SinglyLinkedList(){}

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
  Node<E> reverseIteratively(Node<E> node){
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
  Node<E> reverseRecursively(Node<E> head){
    if(head == null || head.next == null) return head;
    Node<E> rest = reverseRecursively(head.next);
    head.next.next=head;
    head.next=null;
    return rest;
  }

  void printAll(){
    Node<E> temp = head;
    if(temp==null){
      System.out.println("this list is empty");
      return;
    }
    while(temp!=null){
      System.out.println(temp.data);
      temp = temp.next;
    }
    return;
  }

  // driver
  public static void main(String[] args) {
    // push, append, reverse
    SinglyLinkedList<Integer> SLL = new SinglyLinkedList<>();
    // push test
    SLL.push(1);
    SLL.push(2);
    SLL.push(3);
    SLL.push(4);
    SLL.printAll();

    // append test
    SLL.append(2);
    SLL.append(3);
    SLL.append(4);
    SLL.printAll();

    SLL.deleteList();
    SLL.printAll();
  }
}
class SinglyLinkedList {
  static Node head;
  class Node {
    Object data;
    Node next;
    Node(Object data) {
      this.data = data;
    }
  }

  void deleteList() { head = null; }

  // T(1) S(1)
  void push(int new_data){
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
  }

  // T(N) S(1)
  void append(int new_data){
    Node new_node = new Node(new_data);

    if(head == null) {
      head = new Node(new_data);
      return;
    }

    new_node.next = null;

    Node last = head;
    while(last.next!= null) last = last.next;

    last.next = new_node;
    return;
  }
  
  // T(N) S(1)
  Node reverseIteratively(Node node){
    Node prev = null;
    Node current = node;
    Node next = null;
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
  Node reverseRecursively(Node head){
    if(head == null || head.next == null) return head;
    Node rest = reverseRecursively(head.next);
    head.next.next=head;
    head.next=null;
    return rest;
  }

  // driver
  public static void main(String[] args) {
  }
}

class DoubleLinkedList {
  static Node head;
  class Node {
    Object data;
    Node prev;
    Node next;

    Node(Object data) {
      this.data = data;
    }

    // T(1) S(1)
    void push(Object new_data) {
      Node new_node = new Node(new_data);

      new_node.next = head;
      new_node.prev = null;

      if(head!=null) head.prev = new_node;

      head = new_node;
    }

    // T(1) S(1)
    void InsertAfter(Node prev_node, Object new_data){
      if(prev_node == null) {
        return;
      }

      Node new_node = new Node(new_data);
      new_node.next = prev_node.next;
      prev_node.next = new_node;
      new_node.prev = prev_node;

      if(new_node.next != null) new_node.next.prev = new_node;
    }

    // T(1) S(1)
    void InsertBefore(Node next_node, Object new_data){
      if(next_node == null) {
        return;
      }

      Node new_node = new Node(new_data);
      new_node.prev = next_node.prev;
      next_node.prev = new_node;
      new_node.next = next_node;
      if(new_node.prev != null) new_node.prev.next = new_node;
      else head = new_node;
    }

    // T(N) S(1)
    void append(Object new_data){
      Node new_node = new Node(new_data);
      Node last = head;
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
}




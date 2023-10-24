class LinkedList {
  static Node head;
  
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


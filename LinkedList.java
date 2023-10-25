

class DoublyLinkedList {
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

// NOT DONE
class CircularSinglyLinkedList{
  int size = 0;
  // pointer to first node.
  Node first; 
  // pointer to last node.
  Node last;
  class Node {
    Node next;
    Object data;

    Node(Object data) {
      this.data = data;
    }
  }

  void linkFirst(Object data) {
    Node new_node = new Node(data);
    if(first == null) {
      first = new_node;
      last = new_node;
      new_node.next = first;
    } else {
      last.next = new_node;
      last = new_node;
      last.next = first;
    }
    ++size;
  }

  // todo
  /*void linkLast(Object data){
    Node new_node = new Node(data);
    if(last == null){
      first = new_node;
      last = new_node;
      new_node.next = first;
    } else { */



  void delete(Object data){
    Node curr = first;
    if(first == null) return;

    do {
      Node next_node = curr.next;
      if(next_node.data.equals(data)) {
        if(last==first) { // the list has only one single elem
          first = null;
          last = null; 
        } else {
          curr.next = next_node.next;
          if(first == next_node) first = first.next;
          if(last == next_node) last = curr;
        }
        break;
      }
      curr = next_node;
    } while(curr!=first);
  }

  // returns the first elem in the list.
  public Object getFirst(){
    if(this.first == null) throw new NoSuchElementException();
    return this.first.item;
  }
  // returns the last elem in the list.
  public Object getLast(){
    if(this.last == null) throw new NoSuchElementException();
    return this.last.item;
  }




  
}










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






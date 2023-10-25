import Node.Node;
import java.util.NoSuchElementException;

// NOT DONE
class CircularSinglyLinkedList<E>{
  int size = 0;
  // pointer to first node.
  Node<E> first;
  // pointer to last node.
  Node<E> last;

  void linkFirst(E data) {
    Node<E> new_node = new Node(data);
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

  void delete(E data){
    Node<E> curr = first;
    if(first == null) return;

    do {
      Node<E> next_node = curr.next;
      if(next_node.data.equals(data)) {
        if(last==first) { // the list has only one single elem
          first = null;
          last = null;
        } else {
          curr.next = next_node.next;
          if(first == next_node) first = first.next;
          if(last == next_node) last = curr;
        }
        --size;
        break;
      }
      curr = next_node;
    } while(curr!=first);
  }

  // returns the first elem in the list.
  public E getFirst(){
    if(this.first == null) throw new NoSuchElementException();
    return this.first.data;
  }
  // returns the last elem in the list.
  public E getLast(){
    if(this.last == null) throw new NoSuchElementException();
    return this.last.data;
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[ ");
    Node<E> temp = first;
    if(first==null){
      str.append("]");
      return str.toString();
    }
    do{
//      System.out.println(temp.data);
      str.append(temp.data.toString() + " -> ");
      temp = temp.next;
    }while(temp!=first);

    str.append("HEAD ]");
    return str.toString();
  }

  public static void main(String[] args){
    CircularSinglyLinkedList csll = new CircularSinglyLinkedList<>();
    csll.linkFirst(1);
    csll.linkFirst(2);
    csll.linkFirst(3);
    csll.linkFirst(4);
    csll.linkFirst(5);
    System.out.println(csll.toString());
  }
}






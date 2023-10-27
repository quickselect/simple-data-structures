import Node.Node;
import java.util.NoSuchElementException;

class CircularDoublyLinkedList<E>{
  int size = 0;
  // pointer to first node.
  Node<E> first;

  public CircularDoublyLinkedList(){}

  void deleteList(){
    first = null;
  }

  void push(E new_data){
    Node<E> new_node = new Node(new_data);
    if(first==null){
      new_node.next = new_node.prev = new_node;
      first = new_node;
      return;
    }
    Node<E> last = first.prev;
    new_node.next = first;
    new_node.prev = last;
    last.next = first.prev = new_node;
    first = new_node;
    ++size;
  }

  // T(N) S(1)
  void remove(Node<E> e){
    // list is empty
    if(first == null) throw new NoSuchElementException();

    // find the node.
    Node curr = first, prev_1 = null;
    while(e != curr){
      if(curr.next == first){
        throw new NoSuchElementException();
      }
      prev_1 = curr;
      curr = curr.next;
    }

    if(size == 1){
      first = null;
      --size;
      return;
    }

    // is it the first node?
    if(curr == first) {
      prev_1 = first.prev;
      first = first.next;
      prev_1.next = first;
      first.prev = prev_1;
    } else if (curr.next == first) { // is it the last node?
      prev_1.next = first;
      first.prev = prev_1;
    } else {
      Node<E> temp = curr.next;
      prev_1.next = temp;
      temp.prev = prev_1;
    }
    --size;
    return;
  }
  void InsertAfter(Node<E> prev_node, E new_data) {
    if(prev_node == null) return;

    Node<E> new_node = new Node(new_data);
    new_node.next = prev_node.next;
    prev_node.next.prev = new_node;
    prev_node.next = new_node;
    new_node.prev = prev_node;
    ++size;
  }

  Node<E> insertEnd(Node<E> new_node){
    if(first == null) {
      first.next = first.prev = new_node;
      first = new_node;
      return first;
    }

    Node<E> last = first.prev;

    new_node.next = first;
    first.prev = new_node;
    new_node.prev = last;
    last.next = new_node;
    return new_node;
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

  public void test(){
    Node<E> temp = first;
    int i = 1;
    do {
      System.out.print(i);
      System.out.print(" ");
      System.out.print(temp.data);
      System.out.print(" ");
      System.out.print(temp.next.data);
      System.out.print(" ");
      System.out.print(temp.prev.data);
      System.out.print(" ");
      System.out.println();
      temp = temp.next;
      ++i;
    } while(temp!=first);
  }

  // T(N) S(1)
  public void reverse() {
    Node<E> left = first, right= first;

    // set right to the last item of the list
    while(right.next!=first) right=right.next;

    // two pointers method -- opposite sides
    do {
      // swap datas
      E temp = left.data;
      left.data = right.data;
      right.data = temp;

      left = left.next;
      right = right.prev;
    } while(left!=right && left.prev != right);

    return;
  }

  public static void main(String[] args) {
    CircularDoublyLinkedList<Integer> cdll = new CircularDoublyLinkedList<>();
    cdll.push(1);
    cdll.push(2);
    cdll.push(3);
    cdll.push(4);
    System.out.println(cdll.toString());
    cdll.remove(cdll.first.next.next);
    System.out.println(cdll.toString());
    cdll.reverse();
    System.out.println(cdll.toString());
//    cdll.test();
//    cdll.reverseIteratively()
//    System.out.printl(cdll.toString());
  }

}

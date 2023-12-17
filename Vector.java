import Node.Node;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

public class Vector<E> {
  E[] container = null;
  int currSize = 0;
  int containerSize = 0;

  Vector(int INITIAL_ARRAY_LENGTH){
    E[] arr = (E[]) new Object[INITIAL_ARRAY_LENGTH];
    this.container = arr;
    this.containerSize = INITIAL_ARRAY_LENGTH;
  }

  private void checkBounds(int pos){
    if(pos >= currSize || pos < 0) throw new out_of_range(Integer.toString(pos));
  }

  private boolean isContainerCapacityEnough(){
    if(this.container.length >= this.currSize+1) // currSize plus one because
      return true;                                 // we will add *one* more element.
    else
      return false;
  }

  E at(int pos) {
    checkBounds(pos);
    return container[pos];
  }

  E front(){
    if(this.empty()) throw new NoSuchElementException();
    else return container[0];
  }

  E back() {
    if(this.empty()) throw new NoSuchElementException();
    else return container[currSize-1];
  }

  E[] data() {
    return this.container;
  }

  boolean empty() {
    if(currSize == 0) return true;
    else return false;
  }

  int size() {
    return currSize;
  }

  int capacity() {
    return this.container.length;
  }

  void clear(){
    E[] arr = (E[]) new Object[0];
    this.container = arr;
    this.currSize = 0;
  }

  // inserts value before pos.
  // if currSize + 1 > this.container.length() then T(N) S(N)
  // else T(N) S(1)
  void insert(int pos, E value) {
    checkBounds(pos);

    ++currSize;

    // if it is not the case that current container size is enough.
    if(!isContainerCapacityEnough()) {
      // increase the capacity by 1.5 * N. N being the current container size.
      int newSize = (int) Math.ceil(currSize * 1.5);
      // currSize plus one because we are adding one more element.
      E[] newContainer = (E[]) new Object[newSize];

      // before pos
      for(int i=0;i<=pos;++i){
        newContainer[i]=this.container[i];
      }
      newContainer[pos] = value;
      // after pos
      for(int i=pos+1;i<currSize+1;++i){
        newContainer[i] = this.container[i-1];
      }
      this.container = newContainer;
      this.containerSize = newSize;
      ++this.currSize;
      return;
    } else { // using sliding window technique here
      int left = currSize-1;
      int right = currSize;
      while(left!=pos-1){
        this.container[right] = this.container[left];
        --left;
        --right;
      }
      this.container[pos] = value;
      return;
    }
  }

  void erase(int pos) {
    checkBounds(pos);

    --currSize;

    if(pos == this.currSize){
      this.pop_back();
      return;
    } else {
      while (pos + 1 != currSize + 1) {
        this.container[pos] = this.container[pos + 1];
      }
      this.pop_back(); // remove the duplicated element.
      return;
    }
  }

  // complexity: constant
  // exceptions: throws nothing
  void pop_back(){
    this.container[currSize-1] = null;
    this.currSize -= 1;
  }

  void push_back(E value){
    if(isContainerCapacityEnough()) {
      this.container[currSize] = value;
      ++this.currSize;
    } else {
      int newSize = (int) Math.ceil(currSize * 1.5);
      // currSize plus one because we are adding one more element.
      E[] newContainer = (E[]) new Object[newSize];
      for(int i=0;i<currSize;++i){
        // copy everything to new container
        newContainer[i]=this.container[i];
      }
      newContainer[currSize] = value;
      ++this.currSize;
      this.container = newContainer;
      this.containerSize = newSize;
    }
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[ ");
    for(int i=0;i<currSize;++i){
      if(i!=0)
        str.append(", ");
      str.append(this.container[i]);
    }
    str.append(" ]");
    return str.toString();
  }
  public static void main(String[] args){
    // at, front, back, data, empty, size, capacity, clear, insert, erase, pop_back
    Vector<Integer> test = new Vector<>(10);
    test.push_back(3);
    test.push_back(4);
    test.push_back(5);
    test.push_back(6);
    System.out.println(test.toString());

    System.out.println(test.at(0));
    System.out.println(test.front());
    System.out.println(test.back());

    System.out.println(test.empty());
    System.out.println(test.size());
    System.out.println(test.capacity());

    test.insert(0,1);
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.capacity());

    test.pop_back();
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.capacity());

    test.push_back(55);
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.capacity());

    // ERROR
    test.erase(0);
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.capacity());
  }
}

class out_of_range extends RuntimeException {
  public out_of_range(String message) {
    super(message);
  }
}
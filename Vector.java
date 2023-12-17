import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

public class Vector<E> {
  E[] container = null;
  int currSize = 0;
  int lastElemIndex = 0;

  Vector(int INITIAL_ARRAY_LENGTH){
    //this.container = new Object[size];
    E[] arr = (E[]) new Object[INITIAL_ARRAY_LENGTH];
    this.container = arr;
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
    this.container = null;
    this.currSize = 0;
  }

  // inserts value before pos.
  // if currSize + 1 > this.container.length() then T(N) S(N)
  // else T(N) S(1)
  void insert(int pos, E value) {
    checkBounds(pos);

    ++currSize;

    if(pos == 0) {
      this.push_back(value);
      return;
    }

    // if it is not the case that current container size is enough.
    if(!isContainerCapacityEnough()) {
      // currSize plus one because we are adding one more element.
      E[] newContainer = (E[]) new Object[currSize+1];

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

    if(pos == lastElemIndex){
      lastElemIndex -= 1;
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

  /*void push_back(E value) {
    if(!isContainerCapacityEnough()) {

    }
  }*/
}

class out_of_range extends RuntimeException {
  public out_of_range(String message) {
    super(message);
  }
}
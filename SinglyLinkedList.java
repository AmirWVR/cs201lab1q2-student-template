public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        String s = "";

        if(head == null){
            return s;
        }

        Node<E> next = head;
        while(next.getNext() != null){
            s += next.getElement();
            next = next.getNext();
        }

        s += next.getElement();

        return s;
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }

        if(head == tail){
            E answer = head.getElement();
            head = null;
            tail = null;
            size--;
            return answer;
        }

        Node<E> next = head;
        while(next.getNext() != tail){
            next = next.getNext();
        }
        E answer = tail.getElement();
        tail = next;
        tail.setNext(null);
        size--;

        return answer;
    }

    public void reverse(){    
        Node<E> prev = null;
        Node<E> nextTemp = null;
        Node<E> curr = head;

        while(curr != null){
            nextTemp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextTemp;
        }

        Node<E> temp = head;
        head = tail;
        tail = temp;
    }

    
}
import java.io.IOException;

public class MyList<T> {
    Node<T> head;

    /**
     * Defaul constructor
     */
    public MyList() {
        head = null;
    }

    /**
     * Constructor
     * @param head
     */
    public MyList(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * isEmpty
     * @return
     */
    public boolean isEmpty(){
        return(head == null);
    }

    /**
     * Get length of list
     * @return length
     */
    public int length(){
        int length = 0;
        if(!this.isEmpty()){
            Node<T> current = this.head;
            while(current.next != null){
                length++;
                current = current.next;
            }
            return length;
        }else return length;
    }

    /**
     * insert element into head list
     * @param item
     */
    public void insertToHead(T item){
        Node<T> newNode = new Node<T>(item, null);
        if(isEmpty()){
            this.head = newNode;
            return;
        }
        newNode.setNext(this.head);
        this.head = newNode;
    }

    /**
     * insert element into tail list
     * @param item
     */
    public void insertToTail(T item){
        Node<T> newNode = new Node<T>(item, null);
        if(isEmpty()){
            this.head = newNode;
            return;
        }
        Node<T> tail = head;
        while(tail.getNext() != null){
            tail = tail.getNext();
        }
        tail.setNext(newNode);
    }

    /**
     * Delete element with key item
     * @param item
     */
    public void deleteElement(T item){

        Node<T> current = this.head;
        Node<T> prevNode = null;
        
        if(current != null && current.getInfo().equals(item)){
            this.head = current.getNext();
            return; 
        }

        while(current != null && !current.getInfo().equals(item)){
            prevNode = current;
            current = current.getNext();
        }

        if(current == null){
            return;
        }
        prevNode.setNext(current.getNext());
    }

    /**
     * Swap node info serve for sort method
     * @param firstNode
     * @param secondNode
     * @throws IOException
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) throws IOException{
        if(isEmpty()){
            Display.consoleOutputPrintln("List is empty");
            return;
        }
        T temp = firstNode.getInfo();
        firstNode.setInfo(secondNode.getInfo());
        secondNode.setInfo(temp);
    }

    /**
     * clear list
     */
    public void clear(){
        head = null;
    }

    /**
     * Traverse list
     * @throws IOException
     */
    public void traverse() throws IOException{
        Node<T> current = this.head;
        while(current != null){
            Display.consoleOutputPrintln(current.getInfo().toString());
            current = current.getNext();
        }
    }
}

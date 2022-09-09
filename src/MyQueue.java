public class MyQueue<T> {
    Node<T> head;
    Node<T> tail;

    /**
     * Constructor
     */
    MyQueue(){
        head = tail = null;
    }

    /**
     * Check queue is empty
     * @return
     */
    public boolean isEmpty(){
        return(head == null && tail == null);
    }

    /**
     * Enqueue method of queue structure
     * @param item
     */
    public void enqueue(T item){
        Node<T> newNode = new Node<T>(item, null);
        if(isEmpty()){
            this.head = this.tail = newNode;
            return;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    /**
     * Dequeue method of queue structure
     * @return
     * @throws Exception
     */
    public T dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is null");
        }

        T data = this.head.getInfo();
        this.head = this.head.getNext();
        
        if(this.head == null){
            this.tail = null;
        }
        return data;
    }
    
    /**
     * Get the data stored in the queue
     * @throws Exception
     */
    public void queueInfo() throws Exception{
        while(!isEmpty()){
            Display.consoleOutputPrintln(dequeue().toString());
        }
        Display.consoleOutputPrintln(" ");
    }
}

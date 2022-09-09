public class Node<T> {
    T info;
    Node<T> next;

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * default contructor
     */
    public Node(){}

    /**
     * Contructor
     * @param info
     * @param next
     */
    public Node(T info, Node<T> next){
        this.info = info;
        this.next = next;
    }

    @Override
    public String toString() {
        return (info.toString());
    }
}

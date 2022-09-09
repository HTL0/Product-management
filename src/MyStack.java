import java.io.IOException;
import java.util.EmptyStackException;
public class MyStack<T> {
    Node<T> head;

    /**
     * Constuctor
     */
    MyStack(){
        head = null;
    }

    /**
     * Check stack is empty
     * @return
     */
    public boolean isEmpty(){
        return(head == null);
    }
    
    /**
     * Push method of stack structure
     * @param element
     */
    public void push(T element){
        head = new Node<T>(element, head);
    }

    /**
     * pop method of stack structure
     * @return
     * @throws EmptyStackException
     */
    public T pop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T element = head.getInfo();
        head = head.next;
        return element;
    }

    /**
     * peek method of stack structure 
     * @return
     */
    public T peek() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.head.getInfo();
    }

    /**
     * Get the data stored on the stack
     * @throws IOException
     */
    public void StackInfo() throws IOException{
        while(!this.isEmpty()){
            Display.consoleOutputPrintln(this.pop().toString());
        }
        Display.consoleOutputPrintln(" ");
    }

    /**
     * The method serves for display the stack binary
     * @return
     */
    public int StackBinaryInfo(){
        if(isEmpty()){
            return -1;
        }
        String str = "";
        while(!this.isEmpty()){
            str += this.pop();
        }
        return Integer.parseInt(str);
    }

}

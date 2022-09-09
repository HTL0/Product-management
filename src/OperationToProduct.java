import java.io.*;
import java.util.Scanner;

public class OperationToProduct {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Validate and create Product method 
     * @return
     * @throws IOException
     */
    public Product createProduct(MyList<Product> list) throws IOException{
        String bcode, title, inputQuantity, inputPrice;

        while(true){
            Display.consoleOutputPrint("Input new ID: ");
            bcode = scanner.next();
            Display.inputConsoleWriter(bcode);
            if(checkID(bcode, list)){
                Display.errorMess("ID already exists, please input again!");
                continue;
            }
            break;
        }
        scanner.nextLine();
        Display.consoleOutputPrint("Input Product's Name: ");
        title = scanner.nextLine();
        Display.inputConsoleWriter(title);

        while(true){
            Display.consoleOutputPrint("Product's quantity: ");
            inputQuantity = scanner.next();
            Display.inputConsoleWriter(inputQuantity);
            if(!isInteger(inputQuantity)){
                Display.errorMess("Invalid data, please input again!");
                continue;
            }
            break;
        }
        Integer quantity = Integer.parseInt(inputQuantity);

        while(true){
            Display.consoleOutputPrint("Product's price: ");
            inputPrice = scanner.next();
            Display.inputConsoleWriter(inputPrice);
            if(!isDouble(inputPrice)){
                Display.errorMess("Invalid data, please input again!");
                continue;
            }
            break;
        }
        double price = Double.parseDouble(inputPrice);

        Product p = new Product(bcode, title, quantity, price);
        return p; 
    }

    /**
     * Get all the data from the file and add it to the tail of linked list structure
     * @param fileName
     * @param stack
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list){
        try{
            File f = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                String bcode = values[0].trim();
                String title = values[1].trim();
                Integer quantity;
                double price;
                if(isInteger(values[2])){
                    quantity = Integer.parseInt(values[2].trim());
                }else continue;

                if(isDouble(values[3])){
                    price = Double.parseDouble(values[3].trim());
                }else continue;
                
                Product p = new Product(bcode, title, quantity, price);
                list.insertToTail(p);
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Get all the data from the file and add it to the Stack structure
     * @param fileName
     * @param stack
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack){
        try{
            File f = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                String bcode = values[0].trim();
                String title = values[1].trim();
                Integer quantity;
                double price;
                if(isInteger(values[2])){
                    quantity = Integer.parseInt(values[2].trim());
                }else continue;

                if(isDouble(values[3])){
                    price = Double.parseDouble(values[3].trim());
                }else continue;
                
                Product p = new Product(bcode, title, quantity, price);
                stack.push(p);
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Get all the data from the file and add it to the Queue structure
     * @param fileName
     * @param queue
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue){
        try{
            File f = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                String bcode = values[0].trim();
                String title = values[1].trim();
                Integer quantity;
                double price;
                if(isInteger(values[2])){
                    quantity = Integer.parseInt(values[2].trim());
                }else continue;

                if(isDouble(values[3])){
                    price = Double.parseDouble(values[3].trim());
                }else continue;
                
                Product p = new Product(bcode, title, quantity, price);
                queue.enqueue(p);
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Display all data of linked list with traverse method of list
     * @param list
     * @throws IOException
     */
    public void displayAll(MyList<Product> list) throws IOException{
        if(list.isEmpty()){
            Display.errorMess("List is empty, you need to choose 1 first to load the data !");
            return;
        }
        list.traverse();
    }

    /**
     * save the data of the list to the file
     * @param fileName
     * @param list
     * @throws IOException
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException{
        File file = new File(fileName);
        String fileContent = "ID,Title,Quantity,price\n";
        FileWriter writer;
        Node<Product> current = list.getHead();
        while(current != null){
            fileContent = fileContent.concat(current.getInfo().getBcode() +","+ current.getInfo().getTitle() +","+ current.getInfo().getQuantity()+","+ current.getInfo().getPrice()+ "\n");
            current = current.getNext();
        }

        writer = new FileWriter(file);
        
        writer.write(fileContent);
        writer.close();
    }

    /**
     * Seach element in list by ID
     * @param list
     * @throws IOException
     */
    public void searchByCode(MyList<Product> list) throws IOException{
        if(list.isEmpty()){
            Display.errorMess("List is empty, you need to choose 1 first to load the data !");
            return;
        }
        Display.consoleOutputPrint("Input the ID to search = ");
        String searchID = scanner.next();
        Display.inputConsoleWriter(searchID);
        Node<Product> current = list.head;
        String result = "-1";
        while(current != null){
            if(current.getInfo().getBcode().equals(searchID)){
                result = current.getInfo().toString();
            }
            current = current.getNext();
        }
        Display.consoleOutputPrintln("Result: ");
        Display.consoleOutputPrintln(result);
    }

    /**
     * Seach element in list by ID
     * @param list
     * @throws IOException
     */
    public void deleteByCode(MyList<Product> list) throws IOException{
        if(list.isEmpty()){
            Display.errorMess("List is empty, you need to choose 1 first to load the data !");
            return;
        }
        Display.consoleOutputPrint("Input the ID to delete = ");
        String deleteID = scanner.next();
        Display.inputConsoleWriter(deleteID);
        if(!checkID(deleteID, list)){
            Display.errorMess("item does not exist in list");
            return;
        }

        Node<Product> current = list.getHead();
        while(current != null){
            if(current.getInfo().getBcode().equals(deleteID)){
                break;
            }
            current = current.getNext();
        }
        Product deleteItem = current.getInfo();
        list.deleteElement(deleteItem);
        Display.consoleOutputPrintln("Deleted!");
    }

    
    /**
     * Select pivot as the last element of singly linked list
     * @param start
     * @param end
     * @return
     * @throws IOException
     */
    public Node<Product> paritionLast(MyList<Product> list,Node<Product> start, Node<Product> end) throws IOException{
        if(start == end || start == null || end == null){
            return start;
        }

        Node<Product> pivot_Prev = start;
        Node<Product> current = start;
        Product pivot = end.getInfo();

        //iterate till one before the end, no need to iterate till the end because end is pivot
        //Chỉ lặp đến phần tử trước đuôi của list, không cần lặp đến đuôi vì đuôi là pivot
        while(start != end){
            if(start.getInfo().getBcode().compareTo(pivot.getBcode()) < 0){

                // keep tracks of last modified item
                pivot_Prev = current;
                list.swap(current, start);
                current = current.getNext();
            }
            start = start.getNext();
        }

        //Swap the position of current next suitable index and pivot
        //swap vị trí của current tức là index và pivot phù hợp tiếp theo
        Product temp = current.getInfo();
        current.setInfo(pivot);
        end.setInfo(temp);

        //Return one previous to current because current is not pointing to pivot
        //Trả về Node trước của current vì current hiện tại là pivot
        return pivot_Prev;
    }

    /**
     * Quick sort on singly linked list
     * @param start
     * @param end
     * @throws IOException
     */
    public void quickSort(MyList<Product> list,Node<Product> start, Node<Product> end) throws IOException {

        if(start == null || start == end || start == end.getNext()){
             return;
        }
        
        Node<Product> pivot_Prev = paritionLast(list, start, end);
        quickSort(list, start, pivot_Prev);
        
        //If pivot is picked and moved to the start,that means start and pivot is same so pick from next of pivot
        //Nếu pivot đã chọn và di chuyển đến start, tức là start là pivot -> chợn next of pivot làm start gọi đệ quy 
        if(pivot_Prev != null && pivot_Prev == start){
             quickSort(list, pivot_Prev.getNext(), end);

        //If pivot is in between of the list, start from next of pivot, since we have pivot_prev, so we move two nodes
        //Nếu pivot ở giữa danh sách, start bắt đầu từ node tiếp theo của pivot, vì ta có pivot_prev nên sẽ phải move 2 node.
        }else if(pivot_Prev != null && pivot_Prev.getNext() != null){
             quickSort(list, pivot_Prev.getNext().getNext(), end);
        }
     }

     /**
     * Sort elements in list by Code
     * Call quickSort menthod
     * @param list
     * @throws IOException
     */
    public void sortByCode(MyList<Product> list) throws IOException{
        if(list.isEmpty()){
            Display.errorMess("List is empty, you need to choose 1 first to load the data !");
            return;
        }

        //Find tail of list
        Node<Product> tail = list.getHead();
        while(tail.getNext() != null){
            tail = tail.getNext();
        }
        quickSort(list, list.getHead(), tail);
        Display.consoleOutputPrintln("Successfully!");
    }


    /**
     * Convert to binary use recursive
     * @param i
     * @param stack integer
     * @return stack info
     */
    public int convertToBinary(int i, MyStack<Integer> stack){
        if(i == 0){
            return stack.StackBinaryInfo();
        }
        int binary = i % 2;
            stack.push(binary);
            i = i/2;
        return convertToBinary(i, stack); 
    }


    /**
     * Check String is integer type
     * @param str
     * @return true or false
     */
    public boolean isInteger(String str){
        try{
            Integer.parseInt(str.trim());
        }catch(NumberFormatException e){
            return false;
        }catch(NullPointerException e){
            return false;
        }
        return true;
    }

    /**
     * Check String is double type
     * @param str
     * @return true or false
     */
    public boolean isDouble(String str) {
        try{
            Double.parseDouble(str.trim());
        }catch(NumberFormatException e){
            return false;
        }catch(NullPointerException e){
            return false;
        }
        return true;
    }

    /**
     * check if the id in the list exists
     * @param bcode
     * @param list
     * @return true if exits or false if does not exist
     */
    public boolean checkID(String bcode, MyList<Product> list){
        Node<Product> current = list.getHead();
        while(current != null){
            if(current.getInfo().getBcode().equals(bcode)){
                return true;
            }else current = current.getNext();
        }
        return false;
    }

}

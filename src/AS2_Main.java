import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {
    public static Scanner sc = new Scanner(System.in);
    public static OperationToProduct o = new OperationToProduct();
    public static MyList<Product> list = new MyList<Product>();
    public static void main(String[] args) throws Exception {
    	
        int choice;
        while(true){
            Display.consoleOutputPrintln(" ");
            showMenu();
            choice = checkInt();
            if(choice == 0){
                Display.consoleOutputPrintln(" Good bye, have a nice day!");
                break;
            }
            switch(choice){
                case 1:
                    tableHead();
                    list.clear();
                    o.getAllItemsFromFile("data.txt", list);
                    list.traverse();
                    break;
                case 2:
                    list.insertToTail(o.createProduct(list));
                    Display.consoleOutputPrintln(" ");
                    Display.consoleOutputPrintln("Input completed!");
                    break;
                case 3:
                    tableHead();
                    o.displayAll(list);
                    break;
                case 4:
                    o.writeAllItemsToFile("data.txt", list);
                    Display.consoleOutputPrintln("Save file successfully!");
                    break;
                case 5:
                    o.searchByCode(list);
                    break;
                case 6:
                    o.deleteByCode(list);
                    break;
                case 7:
                    o.sortByCode(list);
                    break;
                case 8:
                    if(list.isEmpty()){
                        Display.errorMess("List is empty, you need to choose 1 first to load the data !");
                        return;
                    }
                    Display.consoleOutputPrint("Quantity = " + list.getHead().getInfo().getQuantity() + " => binary: ");
                    MyStack<Integer> binaryStack = new MyStack<Integer>();
                    Display.consoleOutputPrintln(String.valueOf(o.convertToBinary(list.getHead().getInfo().getQuantity(), binaryStack)));
                    break;
                case 9:
                    Display.consoleOutputPrintln("Load to STACK");
                    tableHead();
                    MyStack<Product> stack = new MyStack<Product>();
                    o.getAllItemsFromFile("data.txt", stack);
                    stack.StackInfo();
                    break;
                case 10:
                    Display.consoleOutputPrintln("Load to QUEUE.");
                    tableHead();
                    MyQueue<Product> queue = new MyQueue<Product>();
                    o.getAllItemsFromFile("data.txt", queue);
                    queue.queueInfo();
                    break;
                default:
                    Display.consoleOutputPrintln("**Invalid choice. Try again.**");

            }
        }
    }

    /**
     * Show menu
     * @throws IOException
     */
    public static void showMenu() throws IOException {
        Display.consoleOutputPrintln("Choose one of this options: ");
        Display.consoleOutputPrintln("Product list:");
        Display.consoleOutputPrintln("1.  Load data from file and display");
        Display.consoleOutputPrintln("2.  Input & add to the end.");
        Display.consoleOutputPrintln("3.  Display data");
        Display.consoleOutputPrintln("4.  Save product list to file.");
        Display.consoleOutputPrintln("5.  Search by ID");
        Display.consoleOutputPrintln("6.  Delete by ID");
        Display.consoleOutputPrintln("7.  Sort by ID.");
        Display.consoleOutputPrintln("8.  Convert to Binary");
        Display.consoleOutputPrintln("9.  Load to stack and display");
        Display.consoleOutputPrintln("10. Load to queue and display.");
        Display.consoleOutputPrintln("0.  Exit");
        Display.consoleOutputPrintln("");
        Display.consoleOutputPrint("Choice: ");
    }

    /**checkInt
     * 
     * Use regex string "^\\d+$" matches the string input
     * if matched parseInt return int
     * @return int num
     * @throws IOException
     */
    public static int checkInt() throws IOException{
        boolean check;
        int num;
        String str = "";
        String regex = "^\\d+$";
        do{
            str = sc.next();
            Display.inputConsoleWriter(str);
            check = str.matches(regex);
            if(!check){
                Display.consoleOutputPrintln("Invalid data, you need input Integer type !");
            }
        }while(!check);
        num = Integer.parseInt(str);
        return num;
    }

    /**
     * Display table header
     * @throws IOException
     */
    public static void tableHead() throws IOException{
        Display.consoleOutputPrintln(" ");
        Display.consoleOutputPrintln(Display.formatString("ID", Display.IDLENGTH) + "|" + Display.formatString("Title", Display.TITLELENGTH) + "|" + Display.formatString("Quantity", Display.QUANTITYLENGTH) + "|" + Display.formatString("Price", Display.PRICELENGTH));
        Display.consoleOutputPrintln("--------------------------------------------------------------------------");
    }

}

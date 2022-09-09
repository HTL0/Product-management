import java.io.*;

/**
 * Class Display
 * Declare constants length to display by each field
 * Declare the formatString method and menthods to record the displayed content to the console
 */
public class Display {

    public final static int IDLENGTH = 10;
    public final static int TITLELENGTH = 20;
    public final static int QUANTITYLENGTH = 10;
    public final static int PRICELENGTH = 20;

    /**
     * default contructor
     */
    Display(){};

    /**
     * format String serve for display
     * @param str
     * @param length
     * @return
     */
    public static String formatString(String str, int length) {
        String space = " ";
        int addSpace = length - str.length();
        for(int i = 0; i < addSpace; i++){
            str += space;
        }
        return str;
    }

    /**
     * alternative to System.out.println()
     * record the content printed to the console to a file
     * @param str
     * @throws IOException
     */
    public static void consoleOutputPrintln(String str) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("console_output.txt", true), true);
        PrintStream console = System.out;
        System.setOut(out);
        System.out.println(str);
        System.setOut(console);
        System.out.println(str);
    }

    /**
     * alternative to System.out.print()
     * record the content printed to the console to a file
     * @param str
     * @throws IOException
     */
    public static void consoleOutputPrint(String str) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("console_output.txt", true), false);
        PrintStream console = System.out;
        System.setOut(out);
        System.out.print(str);
        System.setOut(console);
        System.out.print(str);
    }

    /**
     * save the user input and save it to the file
     * @param str
     * @throws FileNotFoundException
     */
    public static void inputConsoleWriter(String str) throws FileNotFoundException {
        File file = new File("console_output.txt");
        PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
        pw.append(str + "\n");
        pw.close();
    }

    /**
     * display error messenger
     * @param str
     * @throws IOException
     */
    public static void errorMess(String str) throws IOException{
        Display.consoleOutputPrintln(str);
    }
}

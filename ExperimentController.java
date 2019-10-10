import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
/**
 * ExperimentController class that will run the experiments and read the files
 * @Richard Phan
 * @April 22, 2019
 */
public class ExperimentController {
    //Instance variables that are instances of the two indexedset classes
    private TreeIndexedSet<Long> TIS;
    private ListIndexedSet<Long> LIS;
    /**
     * Constructor for objects of type ExperimentController
     */
    public ExperimentController() {
        //Initializes the two instances of IndexedSet
        TIS = new TreeIndexedSet();
        LIS = new ListIndexedSet();
    }
    /**
     * Main method that runs the actual experiment
     * @param args Command Line Argument input
     */
    public static void main(String[] args) {
        ExperimentController EC = new ExperimentController();
        EC.run(args);
        //First index is input file name
        //Second index is output file name
        //Third index is Tree or List (TIS or LIS)
    }
    /**
     * Runs the reading of the input file and writing of the output file
     * @param c The inputs of the Command Line Arguments
     */
    public void run(String[] c) {
        //ArrayList of type string
        ArrayList<String> arr = new ArrayList<String>();
        //Declaration and initialization of an instance of the scanner class
        //This will read the input file
        Scanner sc = null;
        //Try block for the Scanner
        int a = 0;
        int b = 0;
        try{
            sc = new Scanner(new FileReader(c[0]));
            //While there is a next line in the file,
            while(sc.hasNextLine()) {
                //The whole line becomes a single string
                String line = sc.next();
                //Instatiate another instance of the scanner class to read
                //word by word
                Scanner str = new Scanner(line);
                //While there is a next word,
                while(str.hasNextLine()) {
                    //Store word in a variable word
                    String word = str.next();
                    //Add this to the String ArrayList
                    arr.add(word);
                }
            }
        } catch (Exception e) {
        }
        //If the third element in the command line argument is "LIS" then we
        //are dealing with the Sorted ArrayList
        if(c[2].equals("LIS")) {
            //Try block for the PrintWriter
            try{
                //Declare and Initialize a printwriter and decide the name of
                //file
                PrintWriter f = new PrintWriter(c[1]);
                //Begin time
                long t1 = System.currentTimeMillis();
                //Goes through the entire ArrayList
                for(int i = 1; i < arr.size(); i++) {
                    //If the element at i is add...
                    if(arr.get(i).equals("add")) {
                        //Add that element into the List and return true or
                        //false
                        f.println(LIS.add(Long.parseLong(arr.get(i + 1))));
                        //Increase i to skip over the number which would be
                        //next to the add
                        i++;
                        a++;
                        //If the element at i is getKth...
                    } else if(arr.get(i).equals("getKth")) {
                        //Find the kth smallest element and return it
                        f.println(LIS.getKth(Integer.parseInt(arr.get(i + 1))));
                        //Increase i to skip over the number which would be
                        //next to add
                        b++;
                        i++;
                    }
                }
                //End time
                long t2 = System.currentTimeMillis();
                //Calculate duration of time
                long time = t2 - t1;
                //Print run time
                f.println("Run Time: " + time);
                System.out.println(time);
                //Close the PrintWriter
                f.close();
            } catch(Exception e) {
            }
            //If the third element on the command line argument is "TIS"
            //Then we are dealing with the Red Black Tree
        } else if(c[2].equals("TIS")) {
            //Try block for the PrintWriter
            try{
                //Declare and Initialize a printwriter and decide the name of
                //file
                PrintWriter f = new PrintWriter(c[1]);
                //Begin time
                long t1 = System.currentTimeMillis();
                //Goes through the entire ArrayList
                for(int i = 1; i < arr.size(); i++) {
                    //If the element at i is add...
                    if(arr.get(i).equals("add")) {
                        //Add that element into the tree and return true or
                        //false
                        f.println(TIS.add(Long.parseLong(arr.get(i + 1))));
                        //Increase i to skip over the number which would be
                        //next to the add
                        i++;
                        a++;
                        //If the element at i is getKth...
                    } else if(arr.get(i).equals("getKth")) {
                        f.println(TIS.getKth(Integer.parseInt(arr.get(i + 1))));
                        //Increase i to skip over the number which would be
                        //next to the add
                        b++;
                        i++;
                    }
                }
                //End time
                long t2 = System.currentTimeMillis();
                //Calculate duration of time
                long time = t2 - t1;
                //Print run time
                f.println("Run Time: " + time);
                System.out.println(time);
                //Close the PrintWriter
                f.close();
            } catch(Exception e) {
            }
        }
        System.out.println("Add " + a);
        System.out.println("Get " + b);
    }
}

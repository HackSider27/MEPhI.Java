import java.io.*;
import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        try {
            int arr[] = {1, 2, 3};
            int i = arr[100];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            FileReader rd = new  FileReader(new File("fileName.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            Object obj = null;
            obj.toString();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            FileWriter wt = new FileWriter(new File("fileName.txt"));
            wt.close();
            wt.write("Hello");
        } catch (IOException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            Object i = 100;
            Object obj2 = (String) i;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        try {
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + '\n' + e.getClass() + '\n');
        }

        Scanner console = new Scanner(System.in);

        if(console.nextInt() == 1){
            OutOfMemoryErrorEx a = new OutOfMemoryErrorEx();
            a.OutOfMemoryErrorEx();
        }
        else{
            StackOverflowErrorEx a = new StackOverflowErrorEx();
            a.StackOverflowErrorEx(1);
        }
    }
}
package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static task1.Main.way;


public class P01BufferedReader {
    
    public static void main() {
        
        try{
            BufferedReader bReader =
                new BufferedReader(new FileReader(way));

            System.out.println("=== Entire File ===");
            //print out file here
            String str = "";
            while (str != null) {
                str = bReader.readLine();
                System.out.println(str);
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

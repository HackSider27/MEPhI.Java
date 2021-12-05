import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        out.print("Enter the string: ");
        String s = console.nextLine();


        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

            reader.
                    lines()
                    .filter(line -> line.equals(s))
                    .forEach(i -> cnt++);
            out.println("Number of entering of the string: " + cnt);
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(e.getMessage());
        }

    }
}

package task1;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static String way = "C:\\Users\\User\\Desktop\\MEPhI.Java\\lab6\\homework\\task1\\src\\main\\resources\\hamlet.txt";
    public static Path path = Paths.get("/Users/User/Desktop/MEPhI.Java/lab6/homework/task1/src/main/resources/hamlet.txt");

    public static void main(String[] args) throws IOException {
        System.out.println("P01:");
        P01BufferedReader.main();
        System.out.println("\n##############################\nP02:");
        P02NioRead.main();
        System.out.println("\n##############################\nP03:");
        P03NioReadAll.main();
        System.out.println("\n##############################\nP04:");
        P04NioReadAll.main();
    } 
}

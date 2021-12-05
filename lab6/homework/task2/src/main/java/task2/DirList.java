package task2;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class DirList {
    public static void main(String[] args) {


        // Add Try with resources here
        try {
            System.out.println("\n=== Dir list ===");
            // Print directory list here

        /*File f = new File(".");

        String[] paths = f.list();

        assert paths != null;
        for (String pathname : paths) {
            System.out.println(pathname);
        }*/

            Arrays.stream(Objects.requireNonNull(new File(".").listFiles()))
                    .filter(File::isDirectory)
                    .forEach(System.out::println);
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}

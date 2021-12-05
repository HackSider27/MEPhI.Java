package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static task1.Main.path;

public class P02NioRead {

    public static void main() {

        try { // Create Try with Resources here

            System.out.println("\n=== Entire File ===");
            // print lines here
            byte[] bytes = Files.readAllBytes(path);
            String strings = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(strings);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static task1.Main.path;

public class P03NioReadAll {

    public static void main() {

        List<String> fileArr;
        Path file = path;

        try {
            // Read file into array here
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            lines.stream().filter(x->x.contains("Ros.")).forEach(System.out::println);

            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            lines.stream().filter(x->x.contains("Guil.")).forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

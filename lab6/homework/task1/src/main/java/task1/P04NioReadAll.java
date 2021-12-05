package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static task1.Main.path;

public class P04NioReadAll {
    public static void main() throws IOException {

        Path file = path;
        try {
            // Read fileinto array here
            List<String> fileArr = Files.readAllLines(file, StandardCharsets.UTF_8);

            System.out.println("\n=== Lord Count ===");
            long wordCount = 0; // Replace with your pipeline
            wordCount = fileArr.stream().filter(x -> (x.contains("Lord") || (x.contains("lord")))).count();

            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount = 0; // Replace with your pipeline
            wordCount = fileArr.stream().filter(x -> (x.contains("Prison")) || (x.contains("prison"))).count();

            System.out.println("Word count: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

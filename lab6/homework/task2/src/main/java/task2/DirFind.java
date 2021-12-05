package task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirFind {


    public static void main(String[] args) {


        try (Stream<Path> f = Files.find(Paths.get("."), 100,
                (path, basicFileAttributes) -> {
                    File file = path.toFile();
                    return file.isDirectory();
                })) {// Add try with resources


            System.out.println("\n=== Find all dirs ===");

            // Print out directory list here
            f.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package ch3_basics.unit7_simple_io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine()); // output first line printed by user
        System.out.println(scanner.next()); // output next 3 words printed by user

        System.out.println("--------------------");

        // read class file of this very class!
        Scanner classFileScanner = null;
        try {
            classFileScanner = new Scanner(
                    Paths.get("target/classes/ch3_basics/unit7_simple_io/ScannerExample.class"),
                    StandardCharsets.UTF_8
            );

            while (classFileScanner.hasNextLine()) {
                System.out.println(classFileScanner.next());
            }
        } catch (IOException ignored) {
            // no such file, no permission to read, etc.
        }

        System.out.println("That's all!");
    }
}

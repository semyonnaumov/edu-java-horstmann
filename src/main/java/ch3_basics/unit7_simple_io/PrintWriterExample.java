package ch3_basics.unit7_simple_io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class PrintWriterExample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir")); // way to check out the current VM run dir

        try {
            // prints out content into the specified file
            PrintWriter writer = new PrintWriter("./target/fileToPrint", StandardCharsets.UTF_8);

            writer.printf("Some %s ", "interesting");
            writer.print("text is printed ");
            writer.println("here.");
            writer.print("Thanks!");

            writer.close();
        } catch (IOException ignored) {
            // no permission to modify file, etc.
        }
    }
}

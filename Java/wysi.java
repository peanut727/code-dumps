import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class wysi {

    public static void main(String[] args) {

        Random rand = new Random();
        int x;

        try (FileWriter writer = new FileWriter("random_numbers.txt")) {
            do {
                x = rand.nextInt(100000);
                System.out.println(x);
                writer.write(Integer.toString(x)); // Writes the number to the file
                writer.write(System.lineSeparator()); // adds newline character
            } while (x != 727);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


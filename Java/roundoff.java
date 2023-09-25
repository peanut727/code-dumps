import java.text.DecimalFormat;
import java.util.Scanner;

public class roundoff {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {

            Scanner sc = new Scanner(System.in);
        System.out.println("Num: ");
        double number = sc.nextDouble();
        int decimalPlaces = 4;

        // Create a DecimalFormat object with the desired format
        DecimalFormat df = new DecimalFormat("#." + "0".repeat(decimalPlaces));

        // Format the number to the specified decimal places
        String roundedNumber = df.format(number);

        // Convert the formatted string back to a double
        double roundedValue = Double.parseDouble(roundedNumber);

        System.out.println("Original number: " + number);
        System.out.println("Rounded number to " + decimalPlaces + " decimal places: " + roundedValue);
        }
    }
}

import java.util.Scanner;

public class resolutionCalculator {

  public static void main(String [] args) {

    Scanner sc = new Scanner(System.in);

    double height;
    double formula = 4.0 / 3.0;

    System.out.println("Enter tablet height: ");
    height = sc.nextInt();

    double res = formula * height;

    System.out.println("Calculated resolution: " + Math.round(res) + " x " + Math.round(height));

  }
}

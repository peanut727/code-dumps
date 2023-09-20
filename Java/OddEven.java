import java.util.Scanner;

public class OddEven {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input a number: ");
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char index = input.charAt(i);
            int number = Character.getNumericValue(index);

            if (number % 2 == 0) {
                System.out.println(number + " is even");

            } else {

                System.out.println(number + " is odd");
            }
        }
        sc.close();
    }
}

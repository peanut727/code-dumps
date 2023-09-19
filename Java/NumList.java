import java.util.LinkedList;
import java.util.Scanner;


public class NumList {

    public NumList() {

        LinkedList<Integer> num = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to make a list?" + 
                            "\n Type Y if yes and N if no");
                        
                        
        String choice = sc.nextLine().toUpperCase();

        switch (choice) {

                case "Y":
                System.out.println("Enter the first number: ");
                num.add(sc.nextInt());
                System.out.println("Enter the second number: ");
                num.add(sc.nextInt());
                System.out.println("Enter the third number: ");
                num.add(sc.nextInt());

                System.out.println("Search: ");
                  if (num.contains(sc.nextInt())) {
                    System.out.println("Yes, you have listed it.");
                    
                  }
                  else {
                    System.out.println("Not on the list.");
                    
                  }
                 
                break;

                case "N":
                System.out.println("Okay, Thank you!");
        }
    }
    public static void main(String [] args) {
        new NumList();
    }
    
}

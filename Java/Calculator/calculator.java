import java.util.*;

public class calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        operations op = new operations();
        double num1;
        double num2;
        System.out.println("What do you want to use? \nA. Addition\n B. Subtraction\n C. Multiplication\n D. Division");
        System.out.print("Choice: ");
        String choice = sc.nextLine();

        switch(choice.toUpperCase()) {

            case "A":
                System.out.println("Num1: ");
                num1 = sc.nextDouble();
                System.out.println("Num2: ");
                num2 = sc.nextDouble();
                double a = op.add(num1,num2);
                System.out.println(a);
                break;

            case "B":
                System.out.println("Num1: ");
                num1 = sc.nextDouble();
                System.out.println("Num2: ");
                num2 = sc.nextDouble();
                double s = op.sub(num1,num2);
                System.out.println(s);
                break;

            case "C":
                System.out.println("Num1: ");
                num1 = sc.nextDouble();
                System.out.println("Num2: ");
                num2 = sc.nextDouble();
                double m = op.mult(num1,num2);
                System.out.println(m);
                break;

            case "D":
                System.out.println("Num1: ");
                num1 = sc.nextDouble();
                System.out.println("Num2: ");
                num2 = sc.nextDouble();
                double d = op.div(num1,num2);
                System.out.println(d);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
        sc.close();
    }
}
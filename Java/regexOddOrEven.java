import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class regexOddOrEven {

    public static void main(String [] args) {
       
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String evenReg = "[02468]";
        String oddReg  = "[13579]";
        

        Pattern evenPatt = Pattern.compile(evenReg);
        Pattern oddPatt = Pattern.compile(oddReg);
        

        Matcher evenMatch = evenPatt.matcher(input);
        Matcher oddMatch = oddPatt.matcher(input);
        

        boolean containsEven = evenMatch.find();
        boolean containsOdd = oddMatch.find();
        

    
        if (containsEven && !containsOdd) {
            System.out.println("Even");
        } else if (!containsEven && containsOdd) {
            System.out.println("Odd");
        
        } else {
            System.out.print("contains both even and odd");

        }
        }
    }



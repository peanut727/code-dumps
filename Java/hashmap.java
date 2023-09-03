import java.util.HashMap;
import java.util.Scanner;



 public class hashmap {

  public static void main(String[] args) {

  HashMap<String, Integer> lang = new HashMap<>();
  Scanner sc = new Scanner(System.in);

   lang.put("Java", 8);
   lang.put("JS", 1);
   lang.put("Python", 3);

   System.out.println("Name: ");
   String name = sc.nextLine();

   if (lang.containsKey(name)) {


    int language = lang.get(name);
    System.out.println("" + language);

   } else {

     System.out.println("Not Found!");
    
   }
  
  }
}



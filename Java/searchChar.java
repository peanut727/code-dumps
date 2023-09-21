import java.util.Scanner;

public class searchChar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean found = false;
        boolean stop = false;

        while (!stop) {

            System.out.println("Add and search for numbers? Y or N?");
            String choice = sc.nextLine().toUpperCase();

            switch (choice) {

                case "Y":
                    System.out.println("Values to search on: ");
                    String get = sc.nextLine();
                    System.out.println("Search character: ");
                    String search = sc.nextLine();

                    for (int i = 0; i < get.length(); i++) {

                        char index = get.charAt(i);
                        String letter = Character.toString(index);

                        if (search.equals(letter)) {

                            found = true;
                            break;

                        }
                    }
                    if (found) {
                        System.out.println("Match found!");
                    } else {
                        System.out.println("Match not found!");
                    }
                    break;

                case "N":
                    stop = true;
            }

        }

    }
}
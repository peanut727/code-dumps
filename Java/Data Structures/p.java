public class p {

    public static void main(String []args) {

        int rows = 5, k = 0;

    for (int i = 1; i <= rows; ++i, k = 0) { // Outer Loop
      for (int space = 1; space <= rows - i; ++space) { // Inner Loop 1
        System.out.print("  ");
      }

      while (k != 2 * i - 1) { // Inner Loop 2
        System.out.print("* ");
        ++k;
      }

      System.out.println();
        }
    }
  }



public class LinearSearch {

   public static void main(String[] args) {

    int[] numbers = {1, 8, 9 ,6 ,10 ,19};

    int index = Search(numbers, 10);

    if (index != -1) {
        System.out.println("Element found at " + index);
    } else {
         System.out.println("Element not found");
    }


   }

   public static int Search(int [] arr, int val) {

       for (int i = 0; i < arr.length; i++) {
         if (arr[i] == val) {
             return i;
         }
       }

       return -1;

   }

}
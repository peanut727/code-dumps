import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        goods good = new goods();

        String name;
        int barcode;
        double price;

        int codeSearch;
        boolean exit = false;



        while (!exit) {
            System.out.println("What do you want to do?\n 1. Add Products\n 2. Search Products\n 3. Remove Products\n 4. Exit");
            int choices = sc.nextInt();


            switch (choices){

                case 1:
                    System.out.println("Add items:");
                    sc.nextLine();
                    System.out.println("Product Name: ");
                    name = sc.nextLine();
                    System.out.println("Barcode: ");
                    barcode = sc.nextInt();
                    System.out.println("Price: ");
                    price = sc.nextDouble();
                    good.addProducts(name,barcode,price);
                    System.out.println("Added Successfully");
                    break;

                case 2:
                    System.out.println("Search Items:");
                    System.out.println("Search: ");
                    codeSearch = sc.nextInt();

                    ArrayList<Integer> barcodes = good.getBarcode();
                    ArrayList<String> productNames = good.getProductNames();
                    ArrayList<Double> prices = good.getCost();

                    int index = -1;

                    for (int i = 0; i < barcodes.size(); i++) {
                        if (barcodes.get(i) == codeSearch) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        // Item found
                        System.out.println("Item Found:");
                        System.out.println("Name: " + productNames.get(index));
                        System.out.println("Barcode: " + barcodes.get(index));
                        System.out.println("Price: " + prices.get(index));
                    } else {
                        // Item not found
                        System.out.println("Item with Barcode " + codeSearch + " not found.");
                    }
                    break;

                case 3:
                    exit = true;
                    break;
            }
        }
    }
}

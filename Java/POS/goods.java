import java.util.ArrayList;
import java.util.Scanner;

public class goods {

    ArrayList<String> productName = new ArrayList<String>();
    ArrayList<Integer> barcode = new ArrayList<Integer>();
    ArrayList<Double> cost = new ArrayList<Double>();


   public void addProducts (String name, int code, double price) {

       productName.add(name);
       barcode.add(code);
       cost.add(price);

   }

    public ArrayList<String> getProductNames() {
        return productName;
    }

    public ArrayList<Integer> getBarcode() {
       return barcode;
    }

    public ArrayList<Double> getCost() {
       return cost;
    }


}

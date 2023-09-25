import java.util.HashSet;
import java.util.Set;

public class duplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if(seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
       
        duplicate dup = new duplicate();
        int[] num1 = {1,2,3,1};
        int[] num2 = {1,2,3,4};
        int[] num3 = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(dup.containsDuplicate(num1));
        System.out.println(dup.containsDuplicate(num2));
        System.out.println(dup.containsDuplicate(num3));
    }
}

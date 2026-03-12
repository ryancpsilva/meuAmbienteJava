import java.util.ArrayList;

public class Ex03 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            nums.add(i);
        }
        nums.remove(2);
        if (nums.contains(3)) {
            System.out.println("Contém");
        } else {
            System.out.println("Não contém");
        }
        
    }
}
import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 1;
        while (i <= 10) {
            nums.add(i);
            i++;
        }
        for (int j = 0; j < nums.size(); j++) {
            System.out.println(nums.get(j));
        }
    }
}
import java.util.*;

public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if (bitA != bitB) {
                return bitA - bitB;
            }
            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        SortIntegersByTheNumberOf1Bits solver = new SortIntegersByTheNumberOf1Bits();

        // Test 1
        int[] arr1 = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(solver.sortByBits(arr1)));
        // Expected: [0,1,2,4,8,3,5,6,7]

        // Test 2
        int[] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
        System.out.println(Arrays.toString(solver.sortByBits(arr2)));
        // Expected: [1,2,4,8,16,32,64,128,256,512,1024]
    }
}
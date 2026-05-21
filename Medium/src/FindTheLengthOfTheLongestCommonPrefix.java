import java.util.*;

public class FindTheLengthOfTheLongestCommonPrefix {
    public int digits(int x) {
        int cnt = 0;
        while(x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();

        for(int num : arr1) {
            int x = num;
            while(x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }

        int ans = 0;

        for(int num : arr2) {
            int x = num;
            int len = digits(num);

            while(x > 0) {
                if(prefixes.contains(x)) {
                    ans = Math.max(ans, len);
                    break;
                }
                x /= 10;
                len--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindTheLengthOfTheLongestCommonPrefix solver = new FindTheLengthOfTheLongestCommonPrefix();

        // Test 1: arr1 = [1,10,100], arr2 = [1000] -> 3
        int[] arr1_1 = {1, 10, 100};
        int[] arr2_1 = {1000};
        System.out.println(solver.longestCommonPrefix(arr1_1, arr2_1)); // 3

        // Test 2: arr1 = [1,2,3], arr2 = [4,4,4] -> 0
        int[] arr1_2 = {1, 2, 3};
        int[] arr2_2 = {4, 4, 4};
        System.out.println(solver.longestCommonPrefix(arr1_2, arr2_2)); // 0
    }
}
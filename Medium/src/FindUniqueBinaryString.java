import java.util.*;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        int size = (int)Math.pow(2, n);

        int[] nu = new int[size];

        for(String num : nums){
            int val = Integer.parseInt(num, 2);
            nu[val]++;
        }

        for(int i = 0; i < size; i++){
            if(nu[i] == 0){
                String ans = Integer.toBinaryString(i);
                return "0".repeat(n - ans.length()) + ans;
            }
        }

        return "0".repeat(n);
    }

    public static void main(String[] args) {

        FindUniqueBinaryString solver = new FindUniqueBinaryString();

        // Test 1
        String[] nums1 = {"01","10"};
        System.out.println(solver.findDifferentBinaryString(nums1));
        // "11" hoặc "00"

        // Test 2
        String[] nums2 = {"00","01"};
        System.out.println(solver.findDifferentBinaryString(nums2));
        // "11" hoặc "10"

        // Test 3
        String[] nums3 = {"111","011","001"};
        System.out.println(solver.findDifferentBinaryString(nums3));
        // ví dụ: "101"
    }
}
import java.util.*;

public class MaximumTotalDamageWithSpellCasting {

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        long prev1 = 0, prev2 = 0, prev3 = 0;
        int last = -100;
        long ans = 0;

        for (int dmg : keys) {
            long curr = map.get(dmg);

            if (dmg - last <= 2) {
                long take = curr + prev3;
                long skip = prev1;
                ans = Math.max(take, skip);
            } else {
                ans = prev1 + curr;
            }

            prev3 = prev2;
            prev2 = prev1;
            prev1 = ans;
            last = dmg;
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting solver = new MaximumTotalDamageWithSpellCasting();

        // Test 1
        int[] power1 = {1, 1, 3, 4};
        System.out.println(solver.maximumTotalDamage(power1));

        // Test 2
        int[] power2 = {7, 1, 6, 6};
        System.out.println(solver.maximumTotalDamage(power2));

        // Test 3
        int[] power3 = {1, 2, 3, 6, 8, 9};
        System.out.println(solver.maximumTotalDamage(power3)); // test khoang cach
    }
}

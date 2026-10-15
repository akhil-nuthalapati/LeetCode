import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;
        int[] cnt = new int[31];

        for (int x : nums) {
            while (x > 0) {
                int b = Integer.numberOfTrailingZeros(x);
                cnt[b]++;
                x &= x - 1;
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long x = 0;

            for (int b = 30; b >= 0; b--) {
                if (cnt[b] > 0) {
                    x |= 1L << b;
                    cnt[b]--;
                }
            }

            ans = (ans + x * x % MOD) % MOD;
        }

        return (int) ans;
    }
}
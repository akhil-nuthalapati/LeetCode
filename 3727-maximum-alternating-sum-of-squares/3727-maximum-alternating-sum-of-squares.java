
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] freq = new int[40001];
        long total = 0;

        for (int x : nums) {
            int a = Math.abs(x);
            freq[a]++;
            total += (long) a * a;
        }

        long smallest = 0;
        int count = n / 2;

        for (int i = 0; i <= 40000 && count > 0; i++) {
            int take = Math.min(freq[i], count);

            smallest += (long) take * i * i;
            count -= take;
        }

        return total - 2L * smallest;
    }
}
class Solution {
    static final int MOD = 1_000_000_007;
    long[] b1, b2;
    int n;

    void add(long[] b, int i, long v){ 
        for (; i <= n; i += i & -i) b[i] += v; 
        }
    long sum(long[] b, int i) { 
        long s = 0; for (; i > 0; i -= i & -i) s += b[i]; return s;
         }
    long pre(int x) { 
        return sum(b1, x) * x - sum(b2, x);
         }

    public int sumCounts(int[] nums) {
        n = nums.length;
        b1 = new long[n + 2];
        b2 = new long[n + 2];
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long cur = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 2, r = i + 1;       
            long s = pre(r) - pre(l - 1);             
            cur = (cur + 2 * s + (r - l + 1)) % MOD;  
            ans = (ans + cur) % MOD;

            add(b1, l, 1);  add(b1, r + 1, -1);
            add(b2, l, l - 1);  add(b2, r + 1, -r);
            last[nums[i]] = i;
        }
        return (int) ans;
    }
}
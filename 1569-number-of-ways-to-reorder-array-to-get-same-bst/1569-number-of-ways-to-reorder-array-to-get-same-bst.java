import java.util.*;
class Solution {
    static final long MOD = 1_000_000_007L;
    long[] fact, invFact;
    int[] left, right, size;
    long[] ways;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = pow(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) ->
            Integer.compare(nums[a], nums[b]));
        left = new int[n];
        right = new int[n];
        size = new int[n];
        ways = new long[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int idx : order) {
            int last = -1;
            while (!stack.isEmpty() && stack.peek() > idx) {
                last = stack.pop();
            }
            if (!stack.isEmpty()) {
                right[stack.peek()] = idx;
            }
            if (last != -1) {
                left[idx] = last;
            }
            stack.push(idx);
        }
        int root = stack.peekLast();
        dfs(root);
        return (int) ((ways[root] - 1 + MOD) % MOD);
    }
    private void dfs(int node) {
        if (node == -1) {
            return;
        }
        dfs(left[node]);
        dfs(right[node]);
        int l = left[node] == -1 ? 0 : size[left[node]];
        int r = right[node] == -1 ? 0 : size[right[node]];
        long leftWays = left[node] == -1 ? 1 : ways[left[node]];
        long rightWays = right[node] == -1 ? 1 : ways[right[node]];
        size[node] = l + r + 1;
        long choose = fact[l + r] * invFact[l] % MOD;
        choose = choose * invFact[r] % MOD;
        ways[node] = choose * leftWays % MOD;
        ways[node] = ways[node] * rightWays % MOD;
    }
    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}

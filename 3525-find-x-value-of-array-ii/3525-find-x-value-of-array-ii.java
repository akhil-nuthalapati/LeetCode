class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;

    Node merge(Node left, Node right) {

        Node res = new Node(k);

        // Product of the complete segment
        res.prod = (left.prod * right.prod) % k;

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }

        // Prefixes that go through left and into right
        for (int r = 0; r < k; r++) {

            int newRemainder = (left.prod * r) % k;

            res.cnt[newRemainder] += right.cnt[r];
        }

        return res;
    }

    void build(int node, int low, int high, int[] nums) {

        if (low == high) {

            int value = nums[low] % k;

            tree[node].prod = value;
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = (low + high) / 2;

        build(2 * node, low, mid, nums);
        build(2 * node + 1, mid + 1, high, nums);

        tree[node] = merge(tree[2 * node],
                           tree[2 * node + 1]);
    }

    void update(int node, int low, int high,
                int index, int value) {

        if (low == high) {

            value %= k;

            tree[node] = new Node(k);

            tree[node].prod = value;
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = (low + high) / 2;

        if (index <= mid) {
            update(2 * node, low, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, high,
                   index, value);
        }

        tree[node] = merge(tree[2 * node],
                           tree[2 * node + 1]);
    }

    Node query(int node, int low, int high,
               int ql, int qr) {

        if (ql <= low && high <= qr) {
            return tree[node];
        }

        int mid = (low + high) / 2;

        if (qr <= mid) {
            return query(2 * node, low, mid, ql, qr);
        }

        if (ql > mid) {
            return query(2 * node + 1, mid + 1,
                         high, ql, qr);
        }

        Node left = query(2 * node, low, mid,
                          ql, qr);

        Node right = query(2 * node + 1, mid + 1,
                           high, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums,
                             int k,
                             int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node(k);
        }

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Permanent update
            update(1, 0, n - 1,
                   index, value);

            // Query [start ... n-1]
            Node res = query(1, 0, n - 1,
                             start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }
}
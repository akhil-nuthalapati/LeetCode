class Solution {

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] d1 = new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int x = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);

            while (i - x >= 0 && i + x < n &&
                   s.charAt(i - x) == s.charAt(i + x)) {
                x++;
            }

            d1[i] = x--;

            if (i + x > r) {
                l = i - x;
                r = i + x;
            }
        }
        int[] d2 = new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int x = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);

            while (i - x - 1 >= 0 && i + x < n &&
                   s.charAt(i - x - 1) == s.charAt(i + x)) {
                x++;
            }
            d2[i] = x--;
            if (i + x > r) {
                l = i - x - 1;
                r = i + x;
            }
        }
        int ans = 0;
        int start = 0;
        for (int r = k - 1; r < n; r++) {
            int l = r - k + 1;
            if (l >= start && isPalindrome(l, r, d1, d2)) {
                ans++;
                start = r + 1;
                continue;
            }
            l = r - k;
            if (l >= start && isPalindrome(l, r, d1, d2)) {
                ans++;
                start = r + 1;
            }
        }

        return ans;
    }
    private boolean isPalindrome(
        int l,
        int r,
        int[] d1,
        int[] d2
    ) {
        int len = r - l + 1;
        if ((len & 1) == 1) {
            int center = (l + r) / 2;
            return d1[center] >= len / 2 + 1;
        }
        int center = (l + r + 1) / 2;
        return d2[center] >= len / 2;
    }
}
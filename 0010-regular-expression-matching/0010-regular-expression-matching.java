class Solution {
    public boolean isMatch(String s, String p) {
         int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Handle pattern matching empty string (only '*' cases)
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // * matches zero of previous char
                    dp[i][j] = dp[i][j - 2];

                    // * matches one or more of previous char
                    int prevJ = j - 2;
                    if (prevJ >= 0 && ((p.charAt(prevJ) == s.charAt(i - 1)) || p.charAt(prevJ) == '.')) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Direct character match
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {

        int m = grid.size();
        int n = grid[0].size();

        // Path length must be even
        if ((m + n - 1) % 2 != 0)
            return false;

        // First character must be '('
        if (grid[0][0] != '(')
            return false;

        // Last character must be ')'
        if (grid[m - 1][n - 1] != ')')
            return false;

        int maxBalance = m + n;

        vector<vector<bool>> prev(
            n,
            vector<bool>(maxBalance, false)
        );

        vector<vector<bool>> curr(
            n,
            vector<bool>(maxBalance, false)
        );

        for (int i = 0; i < m; i++) {

            // Clear current row
            for (int j = 0; j < n; j++) {
                fill(curr[j].begin(), curr[j].end(), false);
            }

            for (int j = 0; j < n; j++) {

                // Starting cell
                if (i == 0 && j == 0) {
                    curr[j][1] = true;
                    continue;
                }

                for (int balance = 0;
                     balance < maxBalance;
                     balance++) {

                    if (grid[i][j] == '(') {

                        // We need previous balance = balance - 1
                        if (balance > 0) {

                            // From top
                            if (i > 0 &&
                                prev[j][balance - 1]) {

                                curr[j][balance] = true;
                            }

                            // From left
                            if (j > 0 &&
                                curr[j - 1][balance - 1]) {

                                curr[j][balance] = true;
                            }
                        }

                    } else {

                        // We need previous balance = balance + 1

                        // From top
                        if (i > 0 &&
                            balance + 1 < maxBalance &&
                            prev[j][balance + 1]) {

                            curr[j][balance] = true;
                        }

                        // From left
                        if (j > 0 &&
                            balance + 1 < maxBalance &&
                            curr[j - 1][balance + 1]) {

                            curr[j][balance] = true;
                        }
                    }
                }
            }

            swap(prev, curr);
        }

        return prev[n - 1][0];
    }
};
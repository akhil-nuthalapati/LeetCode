class Solution {
public:

    struct Bitset128 {
        unsigned long long low = 0;
        unsigned long long high = 0;

        // Shift all possible balances by +1
        void increase() {
            high = (high << 1) | (low >> 63);
            low <<= 1;
        }

        // Shift all possible balances by -1
        void decrease() {
            low = (low >> 1) | (high << 63);
            high >>= 1;
        }

        // Process '(' or ')'
        void shift(char ch) {
            if (ch == '(')
                increase();
            else
                decrease();
        }

        // Union of two sets of balances
        void merge(const Bitset128& other) {
            low |= other.low;
            high |= other.high;
        }

        // Copy another bitset
        void copy(const Bitset128& other) {
            low = other.low;
            high = other.high;
        }

        // Is balance 0 reachable?
        bool hasZeroBalance() const {
            return low & 1ULL;
        }
    };


    bool hasValidPath(vector<vector<char>>& grid) {

        int m = grid.size();
        int n = grid[0].size();

        // --------------------------------
        // Early checks
        // --------------------------------

        // Number of characters in every path
        // must be even.
        if ((m + n - 1) % 2 != 0)
            return false;

        // First character must be '('
        if (grid[0][0] != '(')
            return false;

        // Last character must be ')'
        if (grid[m - 1][n - 1] != ')')
            return false;


        // --------------------------------
        // DP
        // --------------------------------

        // We only need two rows.
        vector<Bitset128> prev(n);
        vector<Bitset128> curr(n);


        // Starting balance = 0
        // First character is '('
        // Therefore balance = 1.
        curr[0].low = 1ULL;
        curr[0].increase();


        for (int r = 0; r < m; r++) {

            // Reset current row
            for (int c = 0; c < n; c++) {
                curr[c] = Bitset128();
            }

            for (int c = 0; c < n; c++) {

                // Starting cell
                if (r == 0 && c == 0) {
                    curr[c].low = 1ULL;
                    curr[c].increase();
                    continue;
                }

                // Come from top
                if (r > 0) {
                    curr[c].copy(prev[c]);
                }

                // Come from left
                if (c > 0) {
                    curr[c].merge(curr[c - 1]);
                }

                // Process current character
                curr[c].shift(grid[r][c]);
            }

            swap(prev, curr);
        }


        // At destination balance must be 0.
        return prev[n - 1].hasZeroBalance();
    }
};
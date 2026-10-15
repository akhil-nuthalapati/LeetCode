class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int freq[26] = {};

            for (int j = i; j < n; j++) {
                freq[s[j] - 'a']++;

                int common = 0;
                bool balanced = true;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        if (common == 0)
                            common = freq[k];
                        else if (freq[k] != common) {
                            balanced = false;
                            break;
                        }
                    }
                }

                if (balanced)
                    ans = max(ans, j - i + 1);
            }
        }

        return ans;
    }
};
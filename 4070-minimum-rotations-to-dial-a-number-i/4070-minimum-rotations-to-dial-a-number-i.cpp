class Solution {
public:
    int minRotations(string s) {
        int curr =0;
        int ans =0;
        for(char c : s){
            int nxt = c - '0';
            int diff = abs(curr - nxt);
            ans += min(diff,10-diff);
            curr = nxt;
        }
        return ans;
    }
};
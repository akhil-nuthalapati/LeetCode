class Solution {
public:
    int cost(char a,char b){
        int n = a - '0';
        int m = b - '0';
        int diff = abs(n-m);
        return min(diff,10-diff);
    }
    int minRotations(int n, string s) {
        int t = cost('0',s[0]);
        for(int i = 1;i<n;i++){
            t += cost(s[i-1],s[i]);
        }
        int ans = t;
        ans = min(ans,t - cost('0',s[0]) + cost('0',s[n-1]));
        for(int k =1;k<n;k++){
            int can = t - cost(s[k-1],s[k]) + cost(s[k-1],s[n-1]);
            ans = min(ans,can);
        }
        return ans;
    }
};
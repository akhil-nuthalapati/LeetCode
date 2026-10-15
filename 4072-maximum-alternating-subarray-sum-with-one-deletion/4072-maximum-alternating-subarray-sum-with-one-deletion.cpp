class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        const long long neg = -(1LL << 60);
            long long p = neg;
            long long m = neg;
            long long dp = neg;
            long long dm = neg;
        long long ans = neg;
        for(long long x : nums){
            long long np = max(x,m+x);
            long long nm = p -x;
            long long ndp = max(p, dm+x);
            long long ndm = max(m,dp-x);
            p = np;
            m = nm;
            dp = ndp;
            dm = ndm;
            ans =  max({ans,p,m,dp,dm});
        }
        return ans;
    }
};
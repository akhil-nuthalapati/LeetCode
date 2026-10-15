class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        unordered_map<int,int> mp;
        int i;
        for(i=0;i<n;i++){
            int rem = target - nums[i];
            if(mp.find(rem)!=mp.end()){
                return{mp[rem],i};
            }
            mp[nums[i]] = i;
        }
        return{0,0};
    }
};
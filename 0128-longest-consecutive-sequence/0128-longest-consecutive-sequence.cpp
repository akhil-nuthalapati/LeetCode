class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        int i,x,longest=0,cnt=0;
        unordered_set<int> st;
        for(i =0 ;i <n ;i++){
            st.insert(nums[i]);
        }
        for(auto it : st){
            if(st.find(it - 1) == st.end()){
                cnt = 1;
                x = it;
                while(st.find(x+1) != st.end()){
                    x++;
                    cnt++;
                }
                longest = max(longest,cnt);
            }
        }
        return longest;
    }
};
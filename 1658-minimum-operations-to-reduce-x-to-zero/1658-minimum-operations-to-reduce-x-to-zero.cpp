class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
       int cnt = 0;
        int size = nums.size();
        int l = 0;
        int r = 0;
        int sum = 0;
        for(int i =0 ; i<nums.size(); i++) sum += nums[i];
        int rmd = sum - x;
        int maxsum = 0;
        int maxlen = - 1;
        if(rmd >= 0){
            while(l<=r && r<=nums.size()){
                if(maxsum < rmd){
                    maxsum += nums[r];
                    r++;
                }
                else if(maxsum > rmd){
                    maxsum -= nums[l];
                    l++;
                }
                if(maxsum == rmd){
                    if((r-l)>=maxlen){
                        maxlen = r - l;
                    }
                    maxsum -= nums[l];
                    l++;
                }
            }
        }
        else return -1;
        if(maxlen==-1) return -1;
        else return nums.size() - maxlen;
    }
};
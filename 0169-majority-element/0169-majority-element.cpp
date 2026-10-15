class Solution {
public:
    int majorityElement(vector<int>& nums) {
      int cnt =0,cnt1 =0,el,i;
      for(i=0;i<nums.size();i++){
        if(cnt == 0){
            cnt = 1;
            el = nums[i];
        }
        else if(nums[i]==el) cnt++;
        else cnt--;
      }
      return el;
    }
};
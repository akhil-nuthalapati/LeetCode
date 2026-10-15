class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
         int n = nums.size();
         int l =1,r;
         for(r=1;r<n;r++)
         {
            if(nums[r]!=nums[r-1])
            {
                nums[l]=nums[r];
                l+=1;
            }
         }
    return l;
    }
};
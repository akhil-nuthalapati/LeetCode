class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        int i,j;
        for(i=0;i<n;i++){
            if(nums[i]==0)
            {
                j = i;
                break;
            }
        }
        for(i=j+1;i<n;i++){
         if(nums[i]!=0){
            swap(nums[i],nums[j]);
            j++;
         }
        }
    }
};
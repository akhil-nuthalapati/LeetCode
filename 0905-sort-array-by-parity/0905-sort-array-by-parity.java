class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i=0,j=n-1;
        int temp;
        while(i<j){
            if(nums[i]%2!=0){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j--;
            }
            else
            i++;
        }
        return nums;
    }
}
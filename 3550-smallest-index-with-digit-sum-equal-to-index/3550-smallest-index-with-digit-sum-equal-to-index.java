class Solution {
    public int smallestIndex(int[] nums) {
        int sum =0;
        for(int i =0;i<nums.length;i++){
            for(sum = 0;nums[i]!=0;nums[i]/=10)
            sum += nums[i]%10;
        if(sum == i) return i;
        }
        return -1;
    }
}
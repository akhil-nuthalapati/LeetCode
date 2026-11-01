class Solution {
    public int minMoves(int[] nums) {
         int min = nums[0],sum = 0;
         for (int num : nums) {
            if (num < min) {
                min = num;
            }
            sum += num;
        }
        return sum - (min * nums.length);  
    }
}
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i=0;
        int [] temp = new int [n];
        for(i=0;i<n;i++)
        nums[i] = nums[i]*nums[i];
        int head =0;
        int tail = n-1;
        for(int pos = n-1;pos>=0;pos--){
            if(nums[head] > nums[tail]){
                temp[pos] = nums[head];
                head++;
            }
            else{
            temp[pos] = nums[tail];
            tail--;
            }
        }
        return temp;
    }
}
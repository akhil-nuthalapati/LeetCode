class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int count = 0;
        for(int i =0;i<nums.size();i++){
            count = 0;
            boolean[] vis = new boolean[101];
            for(int j =i;j<nums.size();j++){
                int num = nums.get(j);
                if(!vis[num]){
                    vis[num] = true;
                    count++;
                }
                ans += count*count;
            }
        }
        return ans;
    }
}
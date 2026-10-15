class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int i =0,j=0;
        int n = arr.length;
        int bestminlentillindex[] = new int [n];
        Arrays.fill(bestminlentillindex,Integer.MAX_VALUE);
        int result = Integer.MAX_VALUE;
        int bestminlen = Integer.MAX_VALUE;
        int currSum =0;
        while(j<n){
            currSum += arr[j];
            while(i < j && currSum > target)
                currSum -= arr[i++];
            if(currSum == target){
                int len = j-i+1;
                if(i>0 && bestminlentillindex[i-1] != Integer.MAX_VALUE)
                result = Math.min(result , len+bestminlentillindex[i-1]);
                bestminlen = Math.min(bestminlen,len);
            }
            bestminlentillindex[j] = bestminlen;
        j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
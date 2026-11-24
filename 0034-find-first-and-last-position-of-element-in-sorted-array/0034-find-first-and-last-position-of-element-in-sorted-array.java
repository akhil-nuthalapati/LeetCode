class Solution {
    private int lb(int[] arr, int tar){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= tar){
                ans = mid;
                high = mid -1;
            }
            else
              low = mid+1;
        }
        return ans;
    }
    private int ub(int[] arr, int tar){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > tar){
                ans = mid;
                high = mid -1;
            }
            else
              low = mid+1;
        }
        return ans;
    }
    public int[] searchRange(int[] arr, int tar) {
        int n = lb(arr,tar);
        if(n == arr.length || arr[n] != tar) return new int[] {-1,-1};
        return new int[] {n,ub(arr,tar)-1};
    }
}
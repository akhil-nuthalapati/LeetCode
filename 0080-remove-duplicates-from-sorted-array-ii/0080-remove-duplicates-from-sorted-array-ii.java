class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int i,j;
        for(i=2,j=2;i<n;i++){
            if(arr[i] != arr[j-2])
            arr[j++] = arr[i];
        }
        return j++;
    }
}
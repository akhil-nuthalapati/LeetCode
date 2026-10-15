class Solution {
    public int numRescueBoats(int[] p, int lim) {
        int i =0;
        int j = p.length-1;
        int boat =0;
        Arrays.sort(p);
        while(i<=j){
            int res = p[i]+p[j];
            if(res <= lim)
            i++;
            boat++;
            j--;
        }
        return boat;
    }
}
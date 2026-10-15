class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
       int w =  Math.min(rec2[2],rec1[2]) - Math.max(rec1[0],rec2[0]);
       int h = Math.min(rec1[3],rec2[3]) - Math.max(rec1[1],rec2[1]);
       return w > 0 && h > 0;
    }
}
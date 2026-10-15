class Solution {
    public boolean checkOverlap(int radius, int xc, int yc, int x1, int y1, int x2, int y2) {
         int xi,yi;
         if(xc < x1) xi = x1;
         else if(xc > x2) xi = x2;
         else xi = xc;

         if(yc < y1) yi = y1;
         else if(yc > y2) yi = y2;
         else yi = yc;

         return Math.sqrt(Math.pow((xc-xi),2) + Math.pow((yc-yi),2)) <= radius;
    }
}
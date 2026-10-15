class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxarea = 0;
       int n = height.size();
       int left = 0;
       int right = n-1;
       while(left < right){
        int wid = right - left;
        int hi = min(height[right],height[left]);
        int area = wid * hi;
        maxarea = max(area,maxarea);
        height[left] < height[right] ? left++:right--;
       } 
       return maxarea;
    }
};
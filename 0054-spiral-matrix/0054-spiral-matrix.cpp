class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size(),i;
        int left = 0,right = m-1,top=0,bottom=n-1;
        vector<int> ans;
        while(top <= bottom && left <= right){
        for(i=left;i<=right;i++){
            ans.push_back(mat[top][i]);
        }
         top++;
        for(i=top;i<=bottom;i++){
            ans.push_back(mat[i][right]);
        }
         right--;
         if(top <= bottom){
        for(i=right;i>=left;i--){
            ans.push_back(mat[bottom][i]);
        }
        bottom--;
         }
         if(left <= right){
        for(i=bottom;i>=top;i--){
            ans.push_back(mat[i][left]);
        }
        left++;
        }
        }
        return ans;
    }
};
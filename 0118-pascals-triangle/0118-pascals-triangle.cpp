class Solution {
public:
    vector<int> rowGen(int row);
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        for(int i = 1; i <= numRows; i++){
            ans.push_back(rowGen(i));
        }

        return ans;
    }
};
vector<int> Solution :: rowGen(int row){
    vector<int> ans;
    long long val = 1;
    ans.push_back(1);
    for(int col = 1; col < row; col++){
        val = val * (row - col);
        val = val / col;
        ans.push_back(val);
    }
    return ans;
}
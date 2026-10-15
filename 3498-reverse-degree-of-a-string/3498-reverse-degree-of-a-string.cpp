class Solution {
public:
    int reverseDegree(string s) {
        int degree = 0;
        for(int i = 0;i < s.length();i++){
            int charval = 'z' - s[i] + 1;
            degree += charval*(i+1);
        }
        return degree;
    }
};
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(),strs.end());
        int ind = 0;
        string str1 = strs[0];
        string strend = strs[strs.size() - 1];
        while(ind < str1.size() && ind < strend.size()){
            if(str1[ind]==strend[ind]) ind++;
            else
            break;
        }
        return ind==0?"":str1.substr(0,ind);
    }
};
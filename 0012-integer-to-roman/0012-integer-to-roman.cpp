class Solution {
public:
    string intToRoman(int num) {
        vector<int> val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        vector<string> sym = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        string ans = "";int i=0;
        while(i<13)
        {
            if(i<=12 && num>=val[i]){
            ans+=sym[i];
            num-=val[i];
            }
            else
            i++;
        }
        return ans;  
    }
};
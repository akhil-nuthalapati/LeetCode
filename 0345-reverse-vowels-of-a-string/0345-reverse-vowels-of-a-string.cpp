class Solution {
public:
    bool isVowel(char cha){
        if(cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' || cha == 'u' || cha == 'A' || cha == 'E' || cha == 'I' || cha == 'O' || cha == 'U')
        return 1;
    return 0;
    }
    string reverseVowels(string s) {
        int i =0;
        int j = s.length()-1;
        while(i<j){
            if(!isVowel(s[i])) i++;
            else if(!isVowel(s[j])) j--;
            else{ swap(s[i],s[j]);
                  i++;
                  j--;
            }
        }
        return s;
    }
};
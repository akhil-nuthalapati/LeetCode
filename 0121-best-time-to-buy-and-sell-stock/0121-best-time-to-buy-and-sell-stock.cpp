class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit =0;
       int mini = prices[0],i;
       for(i=0;i<prices.size();i++){
        int cost = prices[i]-mini;
        mini = min(mini,prices[i]);
        profit = max(cost,profit);
       }  
       return profit;      
    }
};
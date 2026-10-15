class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int mn = nums[0], mx = nums[0];

        for (int v : nums) {
            mn = min(mn, v);
            mx = max(mx, v);
        }

        vector<int> cnt(mx - mn + 1);

        for (int v : nums)
            ++cnt[v - mn];

        int k = 0;

        for (int i = 0; i < cnt.size(); ++i)
            for (; cnt[i]--; )
                nums[k++] = i + mn;

        return nums;
    }
};

import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        int left = lowerBound(nums, target);
        int right = upperBound(nums, target);

        List<Integer> ans = new ArrayList<>();

        for (int i = left; i < right; i++) {
            ans.add(i);
        }

        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}

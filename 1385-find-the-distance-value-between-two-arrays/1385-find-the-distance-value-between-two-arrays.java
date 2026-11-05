class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int w = d + 1;
        Map<Integer, int[]> box = new HashMap<>();
        for (int b : arr2) {
            int k = Math.floorDiv(b, w);
            box.computeIfAbsent(k, key -> new int[]{b, b});
            int[] minMax = box.get(k);
            minMax[0] = Math.min(minMax[0], b);
            minMax[1] = Math.max(minMax[1], b);
        }
        
        int count = 0;
        for (int a : arr1) {
            int k = Math.floorDiv(a, w);
            int[] left = box.get(k - 1);
            int[] right = box.get(k + 1);
            if (!box.containsKey(k) && 
                (left == null || left[1] < a - d) && 
                (right == null || right[0] > a + d)) {
                count++;
            }
        }
        return count;
    }
}
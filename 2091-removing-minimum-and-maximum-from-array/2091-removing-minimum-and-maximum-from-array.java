class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int maxInd = 0;
        int minInd = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                maxInd = i;
            }

            if (nums[i] == min) {
                minInd = i;
            }
        }

        int left = Math.min(maxInd, minInd);
        int right = Math.max(maxInd, minInd);

        int front = right + 1;
        int back = n - left;
        int both = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, both));
    }
}
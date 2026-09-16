class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0, right = k-1;
        int diff = Integer.MAX_VALUE;
        while(right<n && left<n){
            diff = Math.min(diff, nums[right]-nums[left]);
            left++;
            right++;
        }
        return diff;
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        for(int num: nums){
            k += num - 1;
            if (k < 0) k -= nums[left++] - 1;
        }

        return nums.length - left;
    }
}
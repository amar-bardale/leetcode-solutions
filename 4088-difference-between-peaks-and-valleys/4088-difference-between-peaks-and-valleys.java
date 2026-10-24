class Solution {
    public int peakValleyDifference(int[] nums) {
        int n = nums.length;
        int peak = 0;
        int val = 0;

        for(int i = 1; i<n-1; i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                peak+=nums[i];
            }
            if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                val+=nums[i];
            }
        }
        return peak-val;
    }
}
class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 1; i<n; i++){
            if(nums[i-1]==nums[i]) ans++;
        }

        return ans;
    }
}
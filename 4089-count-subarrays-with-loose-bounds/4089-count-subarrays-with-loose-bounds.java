class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int l = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] >= minK && nums[i] <= maxK){
                l++;
                ans+=(long)l;
            }
            else{
                l = 0;
            }
        }
        return ans;
    }
}
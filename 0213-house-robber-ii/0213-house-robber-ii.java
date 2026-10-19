class Solution {
    private int maxRob(List<Integer> ls){
        int n = ls.size();
        int prev = ls.get(0);
        int prev2 = 0;
        for(int i = 1; i<n; i++){
            int take = ls.get(i);
            if(i>1) take+=prev2;

            int skip = prev;
            int cur = Math.max(take, skip);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(i != 0) ls1.add(nums[i]);
            if(i != n-1) ls2.add(nums[i]);
        }
        
        return Math.max(maxRob(ls1), maxRob(ls2));
    }
}
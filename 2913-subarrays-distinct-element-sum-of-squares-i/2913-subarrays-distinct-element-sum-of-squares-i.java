class Solution {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> st = new HashSet<>();
        int n = nums.size();
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(!st.contains(nums.get(j))) st.add(nums.get(j));
                int s = st.size();
                ans = ans + (s*s);
            }
            st.clear();
        }
        return ans;
    }
}
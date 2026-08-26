class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }

        for(int i = 1; i<100000; i++){
            if(!hs.contains(k*i)){
                return k*i;
            }
        }
        return -1;
    }
}
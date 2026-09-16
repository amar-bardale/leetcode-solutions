class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> st = new HashSet<>();
        int n = candyType.length;
        for(int i = 0; i<n; i++){
            st.add(candyType[i]);
        }
        if(st.size()>=n/2) return n/2;
        return st.size();
    }
}
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int ao = 0, ac = 0, bo = 0, bc = 0;

        int n = seq.length();
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            if(seq.charAt(i)=='('){
                if(ao<=bo){
                    ans[i] = 0;
                    ao++;
                }
                else{
                    ans[i] = 1;
                    bo++;
                }
            }
            else{
                if(ac<=bc){
                    ans[i] = 0;
                    ac++;
                }
                else{
                    ans[i] = 1;
                    bc++;
                }
            }
        }
        return ans;
    }
}
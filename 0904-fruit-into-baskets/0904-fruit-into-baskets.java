class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int back = 0;
        int types = 0;
        int[] freq = new int[fruits.length];
        for(int i = 0; i<fruits.length; i++){
            if(freq[fruits[i]] == 0) types++;
            freq[fruits[i]]++;

            while(types>2){
                freq[fruits[back]]--;

                if(freq[fruits[back]]==0) types--;

                back++;
            }
            ans = Math.max(ans, i-back+1);
        }
        return ans;
    }
}
class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        int left = 0;
        int maxLen = 0;

        for(int i = 0; i<n; i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
            
            while(mp.get(s.charAt(i))>2){
                mp.put(s.charAt(left), mp.get(s.charAt(left)) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
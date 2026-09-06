class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++) sb.append(s.charAt(i));
        
        while(cnt<s.length()){
            char ch = sb.charAt(0);
            for(int i = 1; i<s.length(); i++){
                sb.setCharAt(i-1, sb.charAt(i));
            }
            sb.setCharAt(s.length()-1, ch);
            cnt++;
            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }
}
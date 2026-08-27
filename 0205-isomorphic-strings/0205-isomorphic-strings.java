class Solution {
    public boolean isIsomorphic(String s, String t) {

        Set<Character> st1 = new HashSet<>();
        Set<Character> st2 = new HashSet<>();
        for(int i = 0; i<s.length(); i++){
            st1.add(s.charAt(i));
            st2.add(t.charAt(i));
        }
        if(st1.size()!=st2.size()) return false;


        else{
            Map<Character, Character> mp = new HashMap<>();

            for(int i = 0; i<s.length(); i++){
                if(!mp.containsKey(s.charAt(i))){
                    mp.put(s.charAt(i), t.charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<s.length(); i++){
                sb.append(mp.get(s.charAt(i)));
            }
            if(sb.toString().equals(t)) return true;
        }
        return false;

    }
}
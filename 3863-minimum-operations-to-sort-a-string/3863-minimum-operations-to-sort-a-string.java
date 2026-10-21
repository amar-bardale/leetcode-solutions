class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));

        String str = sb.toString();
        System.out.println(str);

        if(n<=2 && !s.equals(str)) return -1;

        if(s.equals(str)) return 0;

        char mn = 'z';
        char mx = 'a';
        for(int i = 0; i<n; i++){
            if((s.charAt(i)-'a')<(mn-'a')){
                mn = s.charAt(i);
            }
            if((s.charAt(i)-'a')>(mx-'a')){
                mx = s.charAt(i);
            }
        }
        if(s.charAt(0)==mn || s.charAt(n-1)==mx) return 1;

        for(int i = 1; i<n-1; i++){
            if(s.charAt(i)==mn || s.charAt(i)==mx) return 2;
        }

        if(s.charAt(0)==mx || s.charAt(n-1)==mn) return 3;

        return -1;
    }
}
class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < s.length(); k++) {

            int maxFreq = 0;
            int maxChar = 0;

            // Find character with maximum remaining frequency
            for (int i = 0; i < 128; i++) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxChar = i;
                }
            }

            if (maxFreq == 0) break;

            for (int j = 0; j < maxFreq; j++) {
                sb.append((char) maxChar);
            }

            freq[maxChar] = 0;
        }

        return sb.toString();
    }
}
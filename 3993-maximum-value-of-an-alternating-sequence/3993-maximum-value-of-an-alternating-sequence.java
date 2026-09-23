class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n == 1) return s;
        long evenPeaks = (n-1)/2;
        long oddPeaks = n-1-evenPeaks; 

        long ans = s;
        ans+= (long)m*oddPeaks;
        ans-= (long)evenPeaks;

        if(n%2==1) ans++;
        return ans;
    }
}
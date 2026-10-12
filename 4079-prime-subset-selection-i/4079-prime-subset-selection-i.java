class Solution {
    public boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        // Initially, assume all numbers are prime
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = false;

        if (n >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public List<Integer> maxPrimes(int n, int s) {
        boolean[] arr = sieve(n);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for(int i = 2; i<=n; i++){
            if(arr[i] && sum+i<=s){
                ans.add(i);
                sum+=i;
                if(sum==s) break;
            }
        }
        return ans;
    }
}
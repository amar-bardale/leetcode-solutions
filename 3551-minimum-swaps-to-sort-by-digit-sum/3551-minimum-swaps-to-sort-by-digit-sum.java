class Solution {
    private int sumOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sumOfDigits(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        int cnt = 0;
        int idx = 0;

        while (idx < n) {
            if (arr[idx][2] == idx) {
                idx++;
            } else {
                int a = arr[idx][2];

                int[] temp = arr[idx];
                arr[idx] = arr[a];
                arr[a] = temp;

                cnt++;
            }
        }

        return cnt;
    }
}
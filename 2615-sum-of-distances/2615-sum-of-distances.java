class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] dis = new long[n];

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int x = nums[i];

            long leftCount = count.getOrDefault(x, 0);
            long leftSum = sum.getOrDefault(x, 0L);

            dis[i] += i * leftCount - leftSum;

            count.put(x, (int)leftCount + 1);
            sum.put(x, leftSum + i);
        }

        count.clear();
        sum.clear();

        for(int i = n - 1; i >= 0; i--) {
            int x = nums[i];

            long rightCount = count.getOrDefault(x, 0);
            long rightSum = sum.getOrDefault(x, 0L);

            dis[i] += rightSum - i * rightCount;

            count.put(x, (int)rightCount + 1);
            sum.put(x, rightSum + i);
        }

        return dis;
    }
}
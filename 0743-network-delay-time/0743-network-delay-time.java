class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adj = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int[] edge : times)
            adj[edge[0]].add(new int[]{edge[1], edge[2]});

        int[] time = new int[n + 1];
        Arrays.fill(time, (int)1e9);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        time[k] = 0;
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int currTime = curr[1];

            if(currTime > time[node])
                continue;

            for(int[] edge : adj[node]) {

                int next = edge[0];
                int newTime = currTime + edge[1];

                if(newTime < time[next]) {
                    time[next] = newTime;
                    pq.offer(new int[]{next, newTime});
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {

            if(time[i] == (int)1e9)
                return -1;

            ans = Math.max(ans, time[i]);
        }

        return ans;
    }
}
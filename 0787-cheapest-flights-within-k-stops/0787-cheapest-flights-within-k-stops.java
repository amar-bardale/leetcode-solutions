class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, -1});
        int[] prices = new int[n];
        for(int i = 0; i<n; i++) prices[i] = (int)1e9;
        prices[src] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int city = curr[0];
            int price = curr[1];
            int stops = curr[2];
            if(stops>=k){
                if(city==dst && prices[dst]<(int)1e9){
                    return prices[dst];
                }
                else{
                    continue;
                }
            }
            for(int[] way: flights){
                if(way[0]!=city) continue;
                if(prices[way[1]]>price+way[2]){
                    prices[way[1]] = price+way[2];
                    q.offer(new int[]{way[1], prices[way[1]], stops+1});
                }
            }
        }
        if(prices[dst]<(int)1e9) return prices[dst];
        return -1;
    }
}
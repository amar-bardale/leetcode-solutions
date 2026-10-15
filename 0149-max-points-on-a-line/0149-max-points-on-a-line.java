class Solution {
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        
        if(n<=2) return n;

        int globalMax = 1;

        for(int i = 0; i<n; i++){
            int localMax = 0;
            Map<String, Integer> slopeMap = new HashMap<>();

            for(int j = i+1; j<n; j++){
                int dx = points[j][0]-points[i][0];
                int dy = points[j][1]-points[i][1];

                int g = gcd(dx, dy);
                dx/=g;
                dy/=g;

                if(dx<0){
                    dx = -dx;
                    dy = -dy;
                }
                else if(dx==0){
                    dy = Math.abs(dy);
                }

                String slopeKey = dy + "/" + dx;

                slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0)+1);

                localMax = Math.max(localMax, slopeMap.get(slopeKey));
            }
            globalMax = Math.max(globalMax, localMax+1);
        }
        return globalMax;
    }
}
class Twitter {

    Map<Integer, ArrayList<Integer>> follow = new HashMap<>();
    Map<Integer, ArrayList<int[]>> posts = new HashMap<>();

    int time = 0;

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {

        follow.putIfAbsent(userId, new ArrayList<>());

        // User follows themselves
        if (!follow.get(userId).contains(userId)) {
            follow.get(userId).add(userId);
        }

        posts.putIfAbsent(userId, new ArrayList<>());

        // [time, tweetId]
        posts.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        follow.putIfAbsent(userId, new ArrayList<>());

        if (!follow.get(userId).contains(userId)) {
            follow.get(userId).add(userId);
        }

        // Min heap based on time
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int user : follow.get(userId)) {

            if (!posts.containsKey(user))
                continue;

            for (int[] tweet : posts.get(user)) {

                pq.add(tweet);

                // Keep only newest 10
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }

        // Currently oldest -> newest
        Collections.reverse(ans);

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        follow.putIfAbsent(followerId, new ArrayList<>());

        if (!follow.get(followerId).contains(followeeId)) {
            follow.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {

        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove((Integer) followeeId);
        }
    }
}
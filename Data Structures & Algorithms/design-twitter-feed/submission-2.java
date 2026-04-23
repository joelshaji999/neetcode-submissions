class Twitter {

    private static class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id, int time, Tweet next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    private int time = 0; // increasing timestamp
    private Map<Integer, Set<Integer>> follows = new HashMap<>(); // user -> followees
    private Map<Integer, Tweet> tweets = new HashMap<>();         // user -> head of tweet list

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        // user follows self to simplify logic
        follows.computeIfAbsent(userId, k -> {
            Set<Integer> s = new HashSet<>();
            s.add(userId);
            return s;
        }).add(userId);
        // prepend tweet to user's tweet list
        Tweet head = tweets.get(userId);
        tweets.put(userId, new Tweet(tweetId, time++, head));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>(10);

        // Ensure the user exists and follows self
        follows.computeIfAbsent(userId, k -> {
            Set<Integer> s = new HashSet<>();
            s.add(userId);
            return s;
        }).add(userId);

        // Max-heap by tweet time
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Seed heap with the most recent tweet of each followee
        for (int followee : follows.get(userId)) {
            Tweet t = tweets.get(followee);
            if (t != null) pq.offer(t);
        }

        // Pull up to 10 most recent, pushing the next from that user's list each time
        while (!pq.isEmpty() && feed.size() < 10) {
            Tweet cur = pq.poll();
            feed.add(cur.id);
            if (cur.next != null) pq.offer(cur.next);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> {
            Set<Integer> s = new HashSet<>();
            s.add(followerId); // always follow self
            return s;
        }).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot unfollow self
        Set<Integer> set = follows.get(followerId);
        if (set != null) set.remove(followeeId);
    }
}

class Twitter {

    PriorityQueue<int[]> tweet;
    HashMap<Integer, List<Integer>> followers;
    int time;

    public Twitter() {
        tweet = new PriorityQueue<int[]>(Comparator.comparingInt((int[] a) -> a[2]).reversed());
        followers = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweet.offer(new int[] {userId, tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<Integer>();

        List<Integer> followersList = followers.getOrDefault(userId, Collections.emptyList());
        int count = 10;
        Queue<int[]> q = new LinkedList<int[]>();

        while(count != 0 && !tweet.isEmpty()) {
            int[] userTweet = tweet.poll();
            q.offer(userTweet);

            if(userTweet[0] == userId || followersList.contains(userTweet[0])) {
                result.add(userTweet[1]);
                count--;
            }
        }

        while(!q.isEmpty()) {
            tweet.offer(q.poll());
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        List<Integer> list = followers.computeIfAbsent(followerId, k -> new ArrayList<>());
        if(!list.contains(followeeId)) {
            list.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = followers.get(followerId);
        list.remove(Integer.valueOf(followeeId));
        followers.put(followerId, list);
    }
}

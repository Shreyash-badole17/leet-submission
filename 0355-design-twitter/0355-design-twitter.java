public class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followees = new HashMap<>();
    private Map<Integer, Tweet> tweets = new HashMap<>();
    private static final int MAX_TWEETS_PER_USER = 10;

    // Nested tweet node—class‐level declaration only
    private static class Tweet {
        int id, time;
        Tweet next;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() { }

    public void postTweet(int userId, int tweetId) {
        // 1) Ensure user follows themself
        followees.putIfAbsent(userId, new HashSet<>());
        followees.get(userId).add(userId);

        // 2) Prepend new tweet
        Tweet head = tweets.get(userId);
        Tweet t = new Tweet(tweetId, timestamp++);
        t.next = head;
        tweets.put(userId, t);

        // 3) Prune the list after the 10th node
        Tweet curr = t;
        for (int i = 1; i < MAX_TWEETS_PER_USER && curr.next != null; i++) {
            curr = curr.next;
        }
        // cut off any older tweets beyond the 10th
        curr.next = null;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> users = followees.getOrDefault(userId, Collections.emptySet());

        // max-heap on timestamp
        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        // seed with each followee's newest tweet
        for (int uid : users) {
            Tweet t = tweets.get(uid);
            if (t != null) pq.offer(t);
        }

        // pull up to 10 most recent
        while (!pq.isEmpty() && feed.size() < MAX_TWEETS_PER_USER) {
            Tweet top = pq.poll();
            feed.add(top.id);
            if (top.next != null) pq.offer(top.next);
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}




/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
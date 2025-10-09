class SocialMediaPost {
    protected String author;
    protected String content;
    protected String time;

    public SocialMediaPost(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println("Post by " + author + " at " + time + ": " + content);
    }
}

class InstagramPost extends SocialMediaPost {
    private int likes;
    private String hashtags;

    public InstagramPost(String author, String content, String time, int likes, String hashtags) {
        super(author, content, time);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    @Override
    public void display() {
        System.out.println("Instagram Post: " + content + " #" + hashtags + " by @" + author + " - Likes: " + likes);
    }
}

class TwitterPost extends SocialMediaPost {
    private int retweets;

    public TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println("Twitter Post: " + content + " by @" + author + " - Retweets: " + retweets + " (Chars: " + content.length() + ")");
    }
}

class LinkedInPost extends SocialMediaPost {
    private int connections;

    public LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println("LinkedIn Post: " + content + " by " + author + " - Connections reached: " + connections);
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPost[] posts = {
            new InstagramPost("Alice", "Vacation pics", "10:00 AM", 150, "travel,fun"),
            new TwitterPost("Bob", "Java is fun!", "11:00 AM", 75),
            new LinkedInPost("Charlie", "Professional update", "12:00 PM", 200)
        };

        for (SocialMediaPost p : posts) {
            p.display();
        }
    }
}

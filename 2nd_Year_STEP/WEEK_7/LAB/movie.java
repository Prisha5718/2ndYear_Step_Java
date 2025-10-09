class Content {
    protected String title;
    protected String creator;

    public Content(String title, String creator) {
        this.title = title;
        this.creator = creator;
    }

    public void displayInfo() {
        System.out.println("Content: " + title + " by " + creator);
    }
}

class Movie extends Content {
    private double rating;
    private int duration; // in minutes
    private boolean subtitles;

    public Movie(String title, String creator, double rating, int duration, boolean subtitles) {
        super(title, creator);
        this.rating = rating;
        this.duration = duration;
        this.subtitles = subtitles;
    }

    public void displayDetails() {
        System.out.println("Movie: " + title + ", Rating: " + rating + ", Duration: " + duration + " mins, Subtitles: " + subtitles);
    }
}

class TVSeries extends Content {
    private int seasons;
    private int episodes;
    private String nextEpisode;

    public TVSeries(String title, String creator, int seasons, int episodes, String nextEpisode) {
        super(title, creator);
        this.seasons = seasons;
        this.episodes = episodes;
        this.nextEpisode = nextEpisode;
    }

    public void displayDetails() {
        System.out.println("TV Series: " + title + ", Seasons: " + seasons + ", Episodes: " + episodes + ", Next: " + nextEpisode);
    }
}

class Documentary extends Content {
    private String tags;
    private String relatedContent;

    public Documentary(String title, String creator, String tags, String relatedContent) {
        super(title, creator);
        this.tags = tags;
        this.relatedContent = relatedContent;
    }

    public void displayDetails() {
        System.out.println("Documentary: " + title + ", Tags: " + tags + ", Related: " + relatedContent);
    }
}

public class StreamingDemo {
    public static void main(String[] args) {
        Content[] library = {
            new Movie("Inception", "Christopher Nolan", 8.8, 148, true),
            new TVSeries("Stranger Things", "Duffer Bros", 4, 34, "Season 5 Episode 1"),
            new Documentary("Planet Earth", "BBC", "Nature, Wildlife", "Blue Planet")
        };

        for (Content c : library) {
            c.displayInfo();

            if (c instanceof Movie m) {
                m.displayDetails();
            } else if (c instanceof TVSeries t) {
                t.displayDetails();
            } else if (c instanceof Documentary d) {
                d.displayDetails();
            }

            System.out.println();
        }
    }
}

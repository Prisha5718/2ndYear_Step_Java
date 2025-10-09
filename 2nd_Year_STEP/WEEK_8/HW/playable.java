// Playable.java
public interface Playable {
    void play();
    void pause();
}

// MusicPlayer.java
public class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Music is playing...");
    }

    @Override
    public void pause() {
        System.out.println("Music is paused.");
    }
}

// VideoPlayer.java
public class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Video is playing...");
    }

    @Override
    public void pause() {
        System.out.println("Video is paused.");
    }
}

// PlayerTest.java
public class PlayerTest {
    public static void main(String[] args) {
        Playable p1 = new MusicPlayer();
        p1.play();
        p1.pause();

        Playable p2 = new VideoPlayer();
        p2.play();
        p2.pause();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private String album;
    private String filePath;

    public Song(String title, String artist, String album, String filePath) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getFilePath() {
        return filePath;
    }
}

class MusicPlayer {
    private ArrayList<Song> playlist;
    private int currentIndex;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentIndex = -1;
    }

    public void addSong(Song song) {
        playlist.add(song);
        System.out.println(song.getTitle() + " by " + song.getArtist() + " added to the playlist.");
    }

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. Add some songs first.");
            return;
        }

        if (currentIndex == -1) {
            currentIndex = 0;
        }

        Song currentSong = playlist.get(currentIndex);
        System.out.println("Playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
    }

    public void next() {
        if (currentIndex == -1 || currentIndex == playlist.size() - 1) {
            System.out.println("End of playlist.");
            return;
        }

        currentIndex++;
        play();
    }

    public void previous() {
        if (currentIndex <= 0) {
            System.out.println("Beginning of playlist.");
            return;
        }

        currentIndex--;
        play();
    }

    public void stop() {
        currentIndex = -1;
        System.out.println("Playback stopped.");
    }
}

public class MusicPlayerApplication {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        // Creating sample songs
        Song song1 = new Song("Song 1", "Artist 1", "Album 1", "path/to/song1.mp3");
        Song song2 = new Song("Song 2", "Artist 2", "Album 2", "path/to/song2.mp3");
        Song song3 = new Song("Song 3", "Artist 3", "Album 3", "path/to/song3.mp3");

        // Adding songs to the playlist
        musicPlayer.addSong(song1);
        musicPlayer.addSong(song2);
        musicPlayer.addSong(song3);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Music Player Menu ---");
            System.out.println("1. Play");
            System.out.println("2. Next");
            System.out.println("3. Previous");
            System.out.println("4. Stop");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    musicPlayer.play();
                    break;
                case 2:
                    musicPlayer.next();
                    break;
                case 3:
                    musicPlayer.previous();
                    break;
                case 4:
                    musicPlayer.stop();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}

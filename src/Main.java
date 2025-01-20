import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PlaylistCreator creator=new PlaylistCreator();
        String filePath="src/songs.csv";

        List<Song> playlist=creator.createPlaylist(filePath);

        System.out.println("Playlist: ");
        for(Song s:playlist){
            System.out.println(s);
        }

        creator.fetchPlaylist("src/new_songs.csv",playlist);
        System.out.println("write operation done!");
    }
}
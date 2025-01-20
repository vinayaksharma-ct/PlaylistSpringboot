import java.io.*;
import java.util.*;

public class PlaylistCreator {
    public List<Song> createPlaylist(String csvFilePath){
        List<Song> playlist=new ArrayList<>();
        String line;
        String csvSplitBy=",";

        try{
            BufferedReader br=new BufferedReader(new FileReader(csvFilePath));

            line= br.readLine();    //header line

            if(line!=null && line.toLowerCase().contains("title")){
                line=br.readLine();
            }

            while(line!=null){
                String[] songData=line.split(csvSplitBy);

                if(songData.length>=4){
                    String title=songData[0].trim();
                    String artist=songData[1].trim();
                    String album=songData[2].trim();
                    int duration=Integer.parseInt(songData[3].trim());

                    Song song=new Song(title,artist,album,duration);
                    playlist.add(song);
                }

                line=br.readLine();     // reading next line
            }

        }
        catch (IOException | NumberFormatException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return playlist;
    }

    public void fetchPlaylist(String csvFilePath,List<Song> playlist){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(csvFilePath))){

            bw.write("Title,Artist,Album,Duration");
            bw.newLine();

            // Write each song's data
            for (Song song : playlist) {
                bw.write(song.toCsvRow());
                bw.newLine();
            }
            bw.flush();

        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
package com.example.musicPlaylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class MusicPlaylistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicPlaylistApplication.class, args);

		PlaylistCreator creator=new PlaylistCreator();
		String filePath="src/main/resources/songs.csv";

		List<Song> playlist=creator.createPlaylist(filePath);

		System.out.println("Playlist: ");
		for(Song s:playlist){
			System.out.println(s);
		}

		creator.fetchPlaylist("src/main/resources/new_songs.csv",playlist);
		System.out.println("write operation done!");

	}

}

package com.example.playlist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.playlist.domain.Songs;
import com.example.playlist.repository.SongsRepository;

@Service
public class SongsService {
	 @Autowired
	    private SongsRepository repo;
	 
	 public List<Songs> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Songs songs) {
	        repo.save(songs);
	    }
	     
	    public Songs get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	    
		 public List<Songs> listById(long no) {
			 List<Songs> songLists = new ArrayList<Songs>();
		        List<Songs> songlist = repo.findAll();
		        for (Songs songs : songlist) {
					if(songs.getPlaylist_id() == no)
						songLists.add(songs);
				}
		        return songLists;
		    }

}

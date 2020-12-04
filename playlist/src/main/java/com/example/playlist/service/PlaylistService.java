package com.example.playlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.playlist.domain.Playlist;
import com.example.playlist.repository.PlaylistRepository;


@Service
public class PlaylistService {

	 @Autowired
	    private PlaylistRepository repo;
	 
	 public List<Playlist> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Playlist playlist) {
	        repo.save(playlist);
	    }
	     
	    public Playlist get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
}

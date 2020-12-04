package com.example.playlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Songs {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;
    private Long playlist_id;
    
    public Songs() {
		
	}
    
	public Songs(Long id, String name, String singer, Long playlist_id) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.playlist_id = playlist_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Long getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(Long playlist_id) {
		this.playlist_id = playlist_id;
	}

}

package com.example.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.playlist.domain.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	 
	}

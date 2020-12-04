package com.example.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.playlist.domain.Songs;
@Repository
public interface SongsRepository  extends JpaRepository<Songs, Long> {
	 
	}


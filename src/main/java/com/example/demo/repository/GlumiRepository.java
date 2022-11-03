package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Film;
import model.Glumi;

public interface GlumiRepository extends JpaRepository<Glumi, Integer> {
	
	List<Glumi> findByFilm(Film f);
}

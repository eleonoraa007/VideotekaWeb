package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Film;
import model.Zanr;
import model.Zanrfilma;

public interface ZanrFilmRepository extends JpaRepository<Zanrfilma, Integer> {
	List<Zanrfilma> findByFilm(Film f);
	List<Zanrfilma> findByZanr(Zanr z);
	
	@Query("select z from Zanrfilma z where z.zanr.naziv = :naziv")
	public List<Zanrfilma> getFilmZaZanr(@Param("naziv") String naziv);
}

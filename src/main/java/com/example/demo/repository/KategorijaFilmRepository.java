package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Kategorijafilma;

public interface KategorijaFilmRepository extends JpaRepository<Kategorijafilma, Integer> {
	
	@Query("select k from Kategorijafilma k where k.kategorija.naziv = :naziv")
	public List<Kategorijafilma> getFilmIzKategorije(@Param("naziv") String naziv);
}

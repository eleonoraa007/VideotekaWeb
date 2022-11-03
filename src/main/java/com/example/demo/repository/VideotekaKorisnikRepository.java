package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Videotekakorisnik;

@Repository
@Transactional
public interface VideotekaKorisnikRepository extends JpaRepository<Videotekakorisnik, Integer> {
	Videotekakorisnik findByKorisnickoIme(String korisnickoIme);
}

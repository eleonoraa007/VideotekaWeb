package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.GlumacRepository;
import com.example.demo.repository.GlumiRepository;
import com.example.demo.repository.KategorijaFilmRepository;
import com.example.demo.repository.KategorijaRepository;
import com.example.demo.repository.ZanrFilmRepository;
import com.example.demo.repository.ZanrRepository;

import model.Film;
import model.Glumac;
import model.Glumi;
import model.Kategorija;
import model.Kategorijafilma;
import model.Zanr;
import model.Zanrfilma;

@Controller
@RequestMapping(value="/filmovi")
public class FilmKontroler {

	@Autowired
	FilmRepository fr;
	
	@Autowired
	KategorijaRepository kr;
	
	@Autowired
	ZanrRepository zr;
	
	@Autowired
	ZanrFilmRepository zfr;
	
	@Autowired
	KategorijaFilmRepository kfr;
	
	@Autowired
	GlumiRepository gr;
	
	@Autowired
	GlumacRepository glr;
	
	@RequestMapping(value="/getPodaci", method=RequestMethod.GET)
	public String getPodaci(HttpServletRequest request) {
		List<Zanr> zanrovi = zr.findAll();
		List<Glumac> glumci = glr.findAll();
		request.getSession().setAttribute("zanrovi", zanrovi);
		request.getSession().setAttribute("glumci", glumci);
		
		return "UnosFilma";
	}
	
	@RequestMapping(value="/saveFilm", method=RequestMethod.POST)
	public String saveFilm(String naziv, Integer ocena, String opis, Double cena, Integer[] zanrovi, Integer[] glumci, Model m) {
		Film f = new Film();
		f.setNaziv(naziv);
		f.setOcena(ocena);
		f.setOpis(opis);
		f.setCena(cena);
		
		Film film = fr.save(f);
		
		for(Integer id : zanrovi) {
			Zanrfilma zf = new Zanrfilma();
			Zanr z = zr.findById(id).get();
			zf.setZanr(z);
			zf.setFilm(film);
			zfr.save(zf);
		}
		for(Integer idG : glumci) {
			Glumi g = new Glumi();
			Glumac gl = glr.findById(idG).get();
			g.setGlumac(gl);
			g.setFilm(film);
			gr.save(g);
		}
		m.addAttribute("poruka", "Film je uspesno sacuvan");
		
		return "UnosFilma";
	}
	
	@RequestMapping(value="/getKategorije", method=RequestMethod.GET)
	public String getKategorije(HttpServletRequest request) {
		List<Kategorija> kategorije = kr.findAll();
		request.getSession().setAttribute("kategorije", kategorije);
		return "/PrikazKategorija";
	}
	
	@RequestMapping(value="/getFilm", method=RequestMethod.GET)
	public String prikazFilmova(String kategorija, Model m) {
		List<Kategorijafilma> filmovi = kfr.getFilmIzKategorije(kategorija);
		m.addAttribute("filmovi", filmovi);
		m.addAttribute("naziv", kategorija);
		return "/PrikazFilmaZaKategoriju";
	}
	
	@RequestMapping(value="/getZanrovi", method=RequestMethod.GET)
	public String getZanrovi(HttpServletRequest request) {
		List<Zanr> zanrovi = zr.findAll();
		request.getSession().setAttribute("zanrovi", zanrovi);
		return "/PrikazZanrova";
	}
	
	@RequestMapping(value="/getFilm1", method=RequestMethod.GET)
	public String prikazFilma(String zanr, Model m) {
		List<Zanrfilma> filmovi = zfr.getFilmZaZanr(zanr);
		m.addAttribute("filmovi", filmovi);
		m.addAttribute("naziv", zanr);
		return "/PrikazFilmaZaZanr";
	}
	
	@RequestMapping(value="/pretraziFilmove", method=RequestMethod.GET)
	public String pretraziFilmove(String naziv, Model m) {
		Film f = fr.findByNaziv(naziv);
		List<Glumi> glumi = gr.findByFilm(f);
		m.addAttribute("glumi", glumi);
		m.addAttribute("film", naziv);
		return "/PretragaFilma";
	}
	
	@RequestMapping(value="/getPodaci1", method=RequestMethod.GET)
	public String getPodaci1(HttpServletRequest request) {
		List<Film> filmovi = fr.findAll();	
		request.getSession().setAttribute("filmovi", filmovi);
		
		return "UnosGlumca";
	}
	
	@RequestMapping(value="/saveGlumac", method=RequestMethod.POST)
	public String saveGlumac(String ime, String prezime, Integer[] filmovi, Model m) {
		Glumac g = new Glumac();
		g.setIme(ime);
		g.setPrezime(prezime);
		
		Glumac glumac = glr.save(g);
		
		for(Integer idF : filmovi) {
			Glumi glumi = new Glumi();
			Film f = fr.findById(idF).get();
			glumi.setGlumac(glumac);
			glumi.setFilm(f);
			gr.save(glumi);
		}
		
		m.addAttribute("poruka", "Glumac je uspesno sacuvan");
		
		return "UnosGlumca";
	}
	
	
	
}

package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.VideotekaKorisnikRepository;
import com.example.demo.repository.VideotekaUlogaRepository;

import model.Film;
import model.Videotekakorisnik;
import model.Videotekauloga;

@Controller
@ControllerAdvice
@RequestMapping(value = "auth")
public class LoginController {
	
	@Autowired
	VideotekaUlogaRepository r;
	
	@Autowired
	VideotekaKorisnikRepository ur;

	@Autowired
	FilmRepository fr;
	
	@ModelAttribute
	public void getRoles(Model model) {
		List<Videotekauloga> roles=r.findAll();
		model.addAttribute("roles", roles);
		
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
    	return "login";
    }
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String loginHello() {    
	    return "hello";
	     
	 }
	   
	 @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	 public String deniedPage() {    
	    return "access_denied";
	     
	 }
	
	 @RequestMapping(value = "registerUser", method = RequestMethod.GET)
	 public String newUser(Model model) {
		Videotekakorisnik u = new Videotekakorisnik();
		model.addAttribute("user", u);
		return "register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Videotekakorisnik u) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		u.setSifra(passwordEncoder.encode(u.getSifra()));
		
		for(Videotekauloga r : u.getVideotekaulogas()) {
			r.addKorisnik(u);
		}
		ur.save(u);
		return "login";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/auth/loginPage";
    }
	
	 @RequestMapping(value="/pocetna", method = RequestMethod.GET)
	 public String getPocetna () { 
		 return "pocetna";
	 }
	 
	 @RequestMapping(value="/getSvi", method=RequestMethod.GET)
	 public String getSviFilmovi(HttpServletRequest request) {
		 List<Film> film = fr.findAll();
		 request.getSession().setAttribute("film", film);
		 return "SviFilmovi";
	 }
	 
}
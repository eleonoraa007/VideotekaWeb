package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VideotekaKorisnikRepository;

import model.Videotekakorisnik;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private VideotekaKorisnikRepository korisnikRepository;

	 @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Videotekakorisnik user = korisnikRepository.findByKorisnickoIme(username);
		UserDetailsImpl userDetails =new UserDetailsImpl();
		userDetails.setUsername(user.getKorisnickoIme());
		userDetails.setPassword(user.getSifra());
		userDetails.setRoles(user.getVideotekaulogas());
		return userDetails;
			
	 }
}

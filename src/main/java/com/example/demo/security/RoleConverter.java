package com.example.demo.security;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.VideotekaUlogaRepository;

import model.Videotekauloga;

public class RoleConverter implements Converter<String, Videotekauloga> {

	VideotekaUlogaRepository r;
	
	public RoleConverter(VideotekaUlogaRepository r) {
		this.r = r;
	}

	@Override
	public Videotekauloga convert(String source) {
		int idRole=-1;
	    try{
	    	idRole=Integer.parseInt(source);
	    }
	    catch(NumberFormatException e){
	    	throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Videotekauloga.class),idRole, null);
	    }
		Videotekauloga role = r.getReferenceById(idRole);
		return role;
	}
	
	
}

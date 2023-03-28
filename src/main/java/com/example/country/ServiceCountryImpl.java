package com.example.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCountryImpl implements ServiceCountry {
	
	@Autowired
	 RepositoryCountry repositoryCountry;

	@Override
	public void AddCountry(CountryInfo country) {
		repositoryCountry.save(country);
		
	}
	

	@Override
	public CountryInfo getCountryById(long id) {
		CountryInfo country =repositoryCountry.getById(id);
		return country;
	}

	@Override
	public void updateCountry(CountryInfo country) {
		repositoryCountry.save(country);
		
	}

	@Override
	public void deleteCountry(long id) {
		repositoryCountry.deleteById(id);
		
	}


	@Override
	public CountryInfo getCountryByName(String name) {
		CountryInfo country=repositoryCountry.findByName(name);
		
		return country;
		
	}

}

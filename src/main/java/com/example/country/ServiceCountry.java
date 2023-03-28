package com.example.country;

public interface ServiceCountry {
	
	 void AddCountry(CountryInfo country);
	 
	 CountryInfo getCountryById(long id);
	 
    void updateCountry(CountryInfo country);
    
    void deleteCountry(long id);
	
	CountryInfo getCountryByName(String name);
}

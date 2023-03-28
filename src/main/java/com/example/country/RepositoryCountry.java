package com.example.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryCountry extends JpaRepository<CountryInfo, Long> {
	
//	CountryInfo findByCountryId(long id);
	
	CountryInfo findByName(String name);
	

}

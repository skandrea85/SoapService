package com.example.country;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="countryInfo")
@Data
public class CountryInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	    @Id
	    private long id;
	    
	    @Column
	    private String name;
	    
	    @Column
	    private String capital;
	    
	    @Column
	    private int population;
	    
	 
	    @Enumerated(EnumType.STRING)
	    @Column
	    private Currency currency;
	
	

}

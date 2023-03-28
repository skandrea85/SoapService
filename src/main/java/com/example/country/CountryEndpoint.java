package com.example.country;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.baeldung.springsoap.gen.AddCountryRequest;
import com.baeldung.springsoap.gen.AddCountryResponse;
import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.GetCountryRequest;
import com.baeldung.springsoap.gen.GetCountryResponse;
import com.baeldung.springsoap.gen.ServiceStatus;


@Endpoint
public class CountryEndpoint {
	
	
	private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

	@Autowired
	private ServiceCountry serviceCountry;

    

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
       
		Country country = new Country();
		
		
		BeanUtils.copyProperties(serviceCountry.getCountryByName(request.getName()),country);
		CountryInfo mol= serviceCountry.getCountryByName(request.getName());
		country.setCurrency(com.baeldung.springsoap.gen.Currency.fromValue(mol.getCurrency().toString()));
		response.setCountry(country);
		

        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
    @ResponsePayload
    public AddCountryResponse addCountry(@RequestPayload AddCountryRequest request) {
    	AddCountryResponse response = new AddCountryResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

    	CountryInfo countryInfo =new CountryInfo();
    	BeanUtils.copyProperties(request.getCountry(),countryInfo);
    	String currrency= request.getCountry().getCurrency().toString();
    	
    	countryInfo.setCurrency(Currency.fromValue(currrency));
		
		serviceCountry.AddCountry(countryInfo);
		
		
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		

        return response;
    }
	
	

}

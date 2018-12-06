package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		Emp e=new Emp(110, "Scott", "London", 97000);
		HttpEntity req = new HttpEntity<>(e,headers);

		ResponseEntity<String> response =

				rt.exchange("http://localhost:8080/emp/save", 
						HttpMethod.POST, req, String.class);

		System.out.println(response.getBody());
		
		

		
	}

}

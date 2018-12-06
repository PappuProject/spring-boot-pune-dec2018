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

public class GetClient2 {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity<Emp> response =

				rt.exchange("http://localhost:8080/emp/find/104", HttpMethod.GET, req, Emp.class);

		System.out.println(response.getBody().getName());

		ResponseEntity<List<Emp>> response2 =

				rt.exchange("http://localhost:8080/emp/list", HttpMethod.GET, req,
						new ParameterizedTypeReference<List<Emp>>() {
						});

		for (Emp e : response2.getBody()) {
			System.out.println(e.getEmpId()+" "+e.getName()+" "+e.getSalary());
		}
	}

}

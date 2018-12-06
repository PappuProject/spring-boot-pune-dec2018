package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HrRestController {

	@Autowired
	RestTemplate rt;

	@GetMapping(path = "/hr/get", produces = "application/json")
	public ResponseEntity getEmpInfoById(@RequestParam("eid") int id) {
		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity<String> response =

				rt.exchange("http://localhost:8080/emp/find/" + id, HttpMethod.GET, req, String.class);

		return response;
	}

	@PostMapping(path = "/hr/register", produces = "application/json", consumes = "application/json")
	public ResponseEntity registerEmp(@RequestBody Emp e) {
		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity req = new HttpEntity<>(e, headers);

		ResponseEntity<String> response =

				rt.exchange("http://localhost:8080/emp/save", HttpMethod.POST, req, String.class);
		return response;
	}

	@GetMapping(path = "/hr/listEmps", produces = "application/json")
	public ResponseEntity getEmpList() {
		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity<List<Emp>> response2 =

				rt.exchange("http://localhost:8080/emp/list", HttpMethod.GET, req,
						new ParameterizedTypeReference<List<Emp>>() {
						});
		
		return response2;
	}
}

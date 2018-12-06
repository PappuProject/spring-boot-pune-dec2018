package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {
	
	@Autowired
	private EmpRepository repo;

	@RequestMapping(path="/greet",method=RequestMethod.GET)
	public String greet() {
		return "Welcome to Spring REST";
	}
	
	
	//@RequestMapping(path="/emp/find/{id}",
	//		method=RequestMethod.GET,
	//		produces="application/json")
	
	@GetMapping(path="/emp/find/{id}",
			produces="application/json")
	public ResponseEntity findEmp(@PathVariable("id")int id) {
		
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}else {
			return ResponseEntity.ok("{\"status\":\"No Employee Found\"}");
		}
	}
	
	@PostMapping(path="/emp/save",produces="application/json",consumes="application/json")
	public ResponseEntity<String> saveEmp(@RequestBody Emp e) {
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("{\"status\":\"Emp Exists\"}");
		}else {
			repo.save(e);
			return ResponseEntity.ok("{\"status\":\"Employee saved\"}");
		}
	}
	
	@PutMapping(path="/emp/update",produces="application/json",consumes="application/json")
	public ResponseEntity<Emp> updateEmp(@RequestBody Emp e) {
		Emp emp=repo.save(e);
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping(path="/emp/delete",produces="application/json")
	public ResponseEntity<String> removeEmp(@RequestParam("id")int id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("{\"status\":\"Employee Deleted\"}");
		}else {
			return ResponseEntity.ok("{\"status\":\"Employee Does not exist\"}");
		}
	}
	@GetMapping(path="/emp/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList(){
		return ResponseEntity.ok(repo.findAll());
	}
}

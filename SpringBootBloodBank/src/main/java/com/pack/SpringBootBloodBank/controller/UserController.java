package com.pack.SpringBootBloodBank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.SpringBootBloodBank.dao.DonarsRepository;
import com.pack.SpringBootBloodBank.dao.RequestsRepository;
import com.pack.SpringBootBloodBank.dao.UserRepository;
import com.pack.SpringBootBloodBank.model.Admin;
import com.pack.SpringBootBloodBank.model.Donars;
import com.pack.SpringBootBloodBank.model.Requests;
import com.pack.SpringBootBloodBank.model.User;
import com.pack.SpringBootBloodBank.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository repository1;
	
	@Autowired
	DonarsRepository repository2;
	
	@Autowired
	RequestsRepository repository3;
	
	@Autowired
	AdminService repository4;

	@PostMapping(value = "/users")
	  public ResponseEntity<User> postUser(@RequestBody User user) {
	    try {
	    
	      User _user = repository1.save(new User( user.getFirstname(), user.getLastname(),user.getBloodgroup(), user.getCity()));
	      return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

	@PostMapping(value = "/donators")
	  public ResponseEntity<Donars> postUser(@RequestBody Donars donars) {
	    try {

	      Donars _donars = repository2.save(new Donars(donars.getId(),donars.getPatientId(),
	    		  donars.getName(), donars.getBloodGroup(),donars.getTime(),
	    		  donars.getLevel(),donars.getNotes(),donars.getStatus()));
	      return new ResponseEntity<>(_donars, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@PostMapping(value = "/requestors")
	  public ResponseEntity<Requests> postUser(@RequestBody Requests requests) {
	    try {

	      Requests _requests = repository3.save(new Requests( requests.getRequestId(),requests.getPatientName(),
	    		  requests.getBloodGroup(), requests.getCity(),requests.getDoctarName(),requests.getHospitalName(),
	    		  requests.getTime(),requests.getContactName(),requests.getContactNumber(),requests.getEmail(),
	    		  requests.getMessage()));
	      System.out.println(_requests);
	      return new ResponseEntity<>(_requests, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@PutMapping(value = "/requestors1")
	  public ResponseEntity<Requests> postUser1(@RequestBody Requests requests) {
	    try {

	      Requests _requests = repository3.save(new Requests(requests.getId(), requests.getRequestId(),requests.getPatientName(),
	    		  requests.getBloodGroup(), requests.getCity(),requests.getDoctarName(),requests.getHospitalName(),
	    		  requests.getTime(),requests.getContactName(),requests.getContactNumber(),requests.getEmail(),
	    		  requests.getMessage(),requests.getStatus()));
	      return new ResponseEntity<>(_requests, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@GetMapping("/status")
	  public ResponseEntity<List<Requests>> getStatus() {
	    List<Requests> requests = new ArrayList<Requests>();
	    try {
	      repository3.findAll().forEach(requests::add);
	     
	      if (requests.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(requests, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  
	}
	
	@GetMapping("/state")
	  public ResponseEntity<List<Donars>> getState() {
	    List<Donars> donars = new ArrayList<Donars>();
	    try {
	      repository2.findAll().forEach(donars::add);
	     
	      if (donars.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(donars, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  
	}

	
	@GetMapping(value = "requestors/patientName/{patientName}")
	  public ResponseEntity<List<Requests>> findByPatientName(@PathVariable String patientName) {
		
	    try {
	      List<Requests> requests = repository3.findByPatientName(patientName);
	      if (requests.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(requests, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@GetMapping(value = "donators/id/{id}")
	  public ResponseEntity<List<Donars>> findById(@PathVariable long id) {
		
	    try {
	      List<Donars> donars = repository2.findById(id);
	      System.out.println("donars");
	      if (donars.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(donars, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@GetMapping(value = "donators/bloodGroup/{bloodGroup}")
	  public ResponseEntity<List<Donars>> findByBloodGroup(@PathVariable String bloodGroup) {
		
	    try {
	      List<Donars> donars = repository2.findByBloodGroup(bloodGroup);
	      System.out.println("donars");
	      if (donars.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(donars, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@PostMapping(value = "/admin")
	public ResponseEntity<Admin> adminAutentication(@RequestBody Admin admin) {
		try {
			return new ResponseEntity<>(repository4.adminAuthentication(admin), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	  
	}


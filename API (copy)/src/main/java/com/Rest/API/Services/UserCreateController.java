package com.Rest.API.Services;








import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.Rest.API.AES;
import com.Rest.API.Validations;
import com.Rest.API.payload;
import com.Rest.API.exception.usercredinvalid;
import com.Rest.API.model.Group;
import com.Rest.API.model.Userdetails;
import com.Rest.API.model.usercredentials;
import com.Rest.API.repos.usercredentialsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class UserCreateController {

	@Autowired
	usercredentialsRepository userop;
	/**
	 * @param u
	 * @return
	 * @throws usercredinvalid
	 */
	@PostMapping("/createuser")
	public   String  saveusr( @RequestBody usercredentials u)  {
		payload payload=new payload();
	  System.out.println(u.getEmail());
	  System.out.println(u.getPassword());

	Long checker=userop.findbyemail(u.getEmail());

if(u.getEmail().isEmpty() && AES.decrypt(u.getPassword()).isEmpty()  || Validations.isBlankString(u.getEmail())  &&  Validations.isBlankString(AES.decrypt(u.getPassword())))
		{
	payload.setStatus(HttpStatus.BAD_REQUEST);
	payload.setMessage("Empty email_id");
	 ObjectMapper mapper = new ObjectMapper();
     //Converting the Object to JSONString
     String usercred = null;
	try {
		usercred = mapper.writeValueAsString(payload);
	} catch (JsonProcessingException e) {
		
		e.printStackTrace();
	}
			return usercred;
		}
	
	else if(u.getEmail().isEmpty() || Validations.isBlankString(u.getEmail()))
		{
		payload.setStatus(HttpStatus.BAD_REQUEST);
		payload.setMessage("Empty emailId");
		 ObjectMapper mapper = new ObjectMapper();
	     //Converting the Object to JSONString
	     String usercred = null;
		try {
			usercred = mapper.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
			return usercred ;
		}
		else if(AES.decrypt(u.getPassword()).isEmpty() ||AES.decrypt(u.getPassword()).length()==1 && Validations.isBlankString(AES.decrypt(u.getPassword())))
		{
			payload.setStatus(HttpStatus.BAD_REQUEST);
			payload.setMessage("Empty password");
			 ObjectMapper mapper = new ObjectMapper();
		     //Converting the Object to JSONString
		     String usercred = null;
			try {
				usercred = mapper.writeValueAsString(payload );
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			return usercred;
		}
		else if(checker!=0)
{
	payload.setStatus(HttpStatus.CONFLICT);
	payload.setMessage("account already exist");
	 ObjectMapper mapper = new ObjectMapper();
     //Converting the Object to JSONString
     String usercred = null;
	try {
		usercred = mapper.writeValueAsString(payload);
	} catch (JsonProcessingException e) {
		
		e.printStackTrace();
	}
	return usercred;
}
		
		
		else
		{
			if(!Validations.isEmailValid(u.getEmail()))
			{
				payload.setStatus(HttpStatus.CONFLICT);
				payload.setMessage("Invaid email-id");
				 ObjectMapper mapper = new ObjectMapper();
			     //Converting the Object to JSONString
			     String usercred = null;
				try {
					usercred = mapper.writeValueAsString(payload);
				} catch (JsonProcessingException e) {
					
					e.printStackTrace();
				}
				return usercred;
				
				
			}
			else
			{
		userop.save(u);
		
		
		payload.setStatus(HttpStatus.CREATED);	
		payload.setMessage("Account created");
		payload.setA(u);
		 ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String usercred = null;
		try {
			usercred = mapper.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		 return usercred;
			}
	}                                              
	}
	
		 
	@PostMapping("/createusers")
	public   ResponseEntity<payload>  saveusrs( @RequestBody usercredentials u){
		payload payload=new payload();
	  System.out.println(u.getEmail());
	  System.out.println(u.getPassword());

	Long checker=userop.findbyemail(u.getEmail());

		

	
		


	
if(u.getEmail().isEmpty() && AES.decrypt(u.getPassword()).isEmpty()  || Validations.isBlankString(u.getEmail())  &&  Validations.isBlankString(AES.decrypt(u.getPassword())))
		{
	payload.setStatus(HttpStatus.BAD_REQUEST);
	payload.setMessage("Empty email_id");
	
			return ResponseEntity.badRequest().body(payload);
		}
	
	else if(u.getEmail().isEmpty() || Validations.isBlankString(u.getEmail()))
		{
		payload.setStatus(HttpStatus.BAD_REQUEST);
		payload.setMessage("Empty emailId");
		/* ObjectMapper mapper = new ObjectMapper();
	     //Converting the Object to JSONString
	     String usercred = null;
		try {
			usercred = mapper.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}*/
		return ResponseEntity.badRequest().body(payload);
		}
		else if(AES.decrypt(u.getPassword()).isEmpty() ||AES.decrypt(u.getPassword()).length()==1 && Validations.isBlankString(AES.decrypt(u.getPassword())))
		{
			payload.setStatus(HttpStatus.BAD_REQUEST);
			payload.setMessage("Empty password");
			/* ObjectMapper mapper = new ObjectMapper();
		     //Converting the Object to JSONString
		     String usercred = null;
			try {
				usercred = mapper.writeValueAsString(payload );
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}*/
			return ResponseEntity.badRequest().body(payload);
		}
		else if(checker!=0)
{
	payload.setStatus(HttpStatus.CONFLICT);
	payload.setMessage("account already exist");
	 /*ObjectMapper mapper = new ObjectMapper();
     //Converting the Object to JSONString
     String usercred = null;
	try {
		usercred = mapper.writeValueAsString(payload);
	} catch (JsonProcessingException e) {
		
		e.printStackTrace();
	}*/
	return ResponseEntity.badRequest().body(payload);
}
		
		
		else
		{
			if(!Validations.isEmailValid(u.getEmail()))
			{
				payload.setStatus(HttpStatus.CONFLICT);
				payload.setMessage("Invaid email-id");
				 /*ObjectMapper mapper = new ObjectMapper();
			     //Converting the Object to JSONString
			     String usercred = null;
				try {
					usercred = mapper.writeValueAsString(payload);
				} catch (JsonProcessingException e) {
					
					e.printStackTrace();
				}*/
				return ResponseEntity.badRequest().body(payload);
				
				
			}
			else
			{
		userop.save(u);
		
		
		payload.setStatus(HttpStatus.CREATED);	
		payload.setMessage("Account created successfully");
		payload.setA(userop.getOne(u.getId()));
		/* ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String usercred = null;
		try {
			usercred = mapper.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}*/
		 return ResponseEntity.ok(payload);
			}
	}                                              
	}
	@GetMapping("/users")
	public ResponseEntity<payload> getallusers()
	{
		
		List<usercredentials> users = userop.findAll();
		payload p=new payload();
		if(users.size()==0)
		{
		throw new usercredinvalid("no content");
		
			
			
		
		}
		else
		{
			p.setMessage("Success");
			p.setStatus(HttpStatus.FOUND);
			p.setA(users);
			return ResponseEntity.ok(p);
		
	}
		
		
		
		
			
	}
	@PostMapping("/createdetails/{id}")
	public Userdetails setdetails(@RequestBody Userdetails ud,@PathVariable(value = "id") Long userid)
	{System.out.println(ud.toString());
	payload p=new payload();
		usercredentials u=userop.getOne(userid);
				/*
		 * Copyright 2020 the original author or authors.
itations under the License.
		 */

		
		u.setUserdetails(ud);
		userop.save(u);
		p.setA(u);
		return u.getUserdetails();
	}
	@GetMapping("/getdetails/{id}")
	public Userdetails getuserdetails(@PathVariable(value = "id") Long userid)
	{
		usercredentials us=userop.getOne(userid);
		return us.getUserdetails();
	}
	@PostMapping("/Creategroup/{id}")
	public ResponseEntity<payload> createAgroup(@RequestBody Group g,@PathVariable(value = "id") Long userid)
	{payload p=new payload();
	System.out.println(userid);
	System.out.println(g.getGroup_name());
		if(g.getGroup_name().isEmpty() && Validations.isBlankString(g.getGroup_name()))
		{
			p.setMessage("Group name is empty");
			p.setStatus(HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(p);
		}
		else
		{
			usercredentials ud=userop.getOne(userid);
			ud.add(g);
			ud=userop.save(ud);
			p.setA(ud.getGroups().get(ud.getGroups().size()-1));
			p.setMessage("Grop created Successfully");
			p.setStatus(HttpStatus.CREATED);
			return ResponseEntity.ok(p);
			
			
		}
		
	}
		
	
	

}

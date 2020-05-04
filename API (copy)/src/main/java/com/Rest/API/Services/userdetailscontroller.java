package com.Rest.API.Services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Rest.API.model.Userdetails;
import com.Rest.API.model.usercredentials;
import com.Rest.API.repos.Userdetailsrepository;

@RestController
public class userdetailscontroller {
	@Autowired
	Userdetailsrepository usd;
	@PostMapping("/createuserdetails")
	public String createdetails(@Valid  @RequestBody Userdetails ud,@PathVariable(value = "id") Long bookId)
	{
		return "hi";
	}
	@GetMapping("/getuserbydetails/{id}")
	public usercredentials getuser(@PathVariable(value = "id") Long detailid)
	{
    Userdetails ud=usd.getOne(detailid);
    
    return ud.getUsercred();
	}
	

}

package com.Rest.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Rest.API.payload;

@ResponseStatus(code = HttpStatus.NO_CONTENT)                       
public class usercredinvalid extends RuntimeException {
	/**
	 * 
	 */payload p=new payload();
	private static final long serialVersionUID = 1L;

	public usercredinvalid(String msg) {
		super(msg);
		p.setMessage(msg);
		
		returner();
      
        }
	payload returner()
	{
	return p;
		
	}

}

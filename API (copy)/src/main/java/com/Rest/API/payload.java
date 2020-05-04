package com.Rest.API;

import org.springframework.http.HttpStatus;





public  class payload {
	private HttpStatus status;
    private Object payload;
    private String message;
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}
public Object getpayload() {
	return payload;
}
public void setA(Object a) {
	this.payload = a;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}

	

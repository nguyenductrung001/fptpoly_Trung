package com.java8;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Person {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json = "{\r\n"
				+ "	\"email\" : [{\r\n"
				+ "	  \"name\" : \"huypn6@fpt.edu.vn\"\r\n"
				+ "	}, {\r\n"
				+ "	  \"name\" : \"huypn2@fsoft.com.vn\"\r\n"
				+ "	}],\r\n"
				+ "	\"skype\": \"huy.mincraft.91\",\r\n"
				+ "	\"face\":  \"facebook.com/huygau301291\",\r\n"
				+ "	\"phone\":\"0356 909 680\"\r\n"
				+ "}\r\n"
				+ "";
		
		ObjectMapper mapper = new ObjectMapper();
		Person person = mapper.readValue(json, Person.class);
		System.out.println(person);
		
		String newJsON = mapper.writeValueAsString(person);
		System.out.println(newJsON);
		
	}
	
	
	
	private List<Email> email;
	private String skype;
	private String face;
	private String phone;
	public List<Email> getEmail() {
		return email;
	}
	public void setEmail(List<Email> email) {
		this.email = email;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [email=" + email + ", skype=" + skype + ", face=" + face + ", phone=" + phone + "]";
	}
	
	
	
}
package org.cafe.domain;

import java.io.Serializable;

import org.joda.time.DateTime;


public class Contact implements Serializable{

	private Long id;
	private int versoin;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private String description;
	private byte[] photo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersoin() {
		return versoin;
	}
	public void setVersoin(int versoin) {
		this.versoin = versoin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public DateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
}

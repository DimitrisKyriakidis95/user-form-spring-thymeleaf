 package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="user")
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	
	@NotEmpty(message = "{firstName is required}")
	@Column(name="user_name")
	private String firstName;
	
	
	@NotEmpty(message = "{lasttName is required}")
	@Column(name="user_surname")
	private String lastName;

	
	@NotNull(message = "{birthDate is required}")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="user_date")
	private  Date date;

   
	@NotEmpty(message = "{homeAdress is required}")
	@Column(name="user_homeAdress")
	private String homeAdress;
   
   
	@NotEmpty(message = "{workAdress is required}")
	@Column(name="user_workAdress")
	private String workAdress;


	
	@NotEmpty(message = "{gender is required}")
	@Column(name="user_gender")
	private String gender;
	
	
	public User() {
		
	}
	
	
	
	
	public User(Integer id, String firstName, String lastName, Date date, String homeAdress, String workAdress,String gender) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.homeAdress = homeAdress;
		this.workAdress = workAdress;
		this.gender = gender;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getHomeAdress() {
		return homeAdress;
	}


	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}


	public String getWorkAdress() {
		return workAdress;
	}


	public void setWorkAdress(String workAdress) {
		this.workAdress = workAdress;
	}


	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", date=" + date
				+ ", homeAdress=" + homeAdress + ", workAdress=" + workAdress + ", gender=" + gender + "]";
	}




	











}

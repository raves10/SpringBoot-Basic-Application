package io.minimalistic.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int id;
	
	@Email
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email.")
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Size(min = 1, message = "Please enter the correct value.")
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
	@Size(min = 1, message = "Please enter the correct value.")
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull
	@Column(name = "location")
	private int location;
	
	@NotNull
	@Min(value = 8, message = "You password must be greater than equal to 8 characters.")
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	

	
	
	public User() {
		//super();
		// TODO Auto-generated constructor stub
	}


	
	public User(int id, String email, String firstName, String lastName, int location, String password,
			String username) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.password = password;
		this.username = username;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", location=" + location
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

	
	

}

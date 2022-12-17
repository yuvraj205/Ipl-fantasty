package com.example.ipl.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@ Column(name="admin_id")
private int id;	
@Column(name="username")
private String userName;
@Column(name="password")
private String password;
public Admin() {
	super();
	
}
public Admin(int id, String userName, String password) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + "]";
}
@Override
public int hashCode() {
	return Objects.hash(id, password, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Admin other = (Admin) obj;
	return id == other.id && Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
}



}

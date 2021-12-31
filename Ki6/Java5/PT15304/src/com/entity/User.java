package com.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

@NamedQueries(@NamedQuery(
		query = "SELECT obj FROM User obj WHERE obj.status=1", 
		name = "User.getLiActive"))
@Entity
@Table(name = "users")
public class User implements Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "number")
	private String number;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "role")
	private Integer role;
	@Column(name="status")
	private Integer status;
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

//	@OneToMany(mappedBy = "user")
//	private List<Favorite> favorite;
//	
//	@OneToMany(mappedBy = "user")
//	private List<Share> share;

//	public List<Favorite> getFavorite() {
//		return favorite;
//	}
//
//	public void setFavorite(List<Favorite> favorite) {
//		this.favorite = favorite;
//	}
//
//	public List<Share> getShare() {
//		return share;
//	}
//
//	public void setShare(List<Share> share) {
//		this.share = share;
//	}
	

}

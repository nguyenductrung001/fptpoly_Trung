package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shares")
public class Share implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "video_id")
	private String video_id;
	@Column(name = "emails")
	private String emails ;
	@Column(name = "share_date")
	private Date share_date;
	
	public Share() {
		// TODO Auto-generated constructor stub
	} 
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getVideo_id() {
		return video_id;
	}


	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}


	public String getEmails() {
		return emails;
	}


	public void setEmails(String emails) {
		this.emails = emails;
	}


	public Date getShare_date() {
		return share_date;
	}


	public void setShare_date(Date share_date) {
		this.share_date = share_date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

//
//	@ManyToOne 
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne 
//	@JoinColumn(name = "vieo_id")
//	private User video;

	
}

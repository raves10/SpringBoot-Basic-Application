package io.minimalistic.models;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postId")
	private int pid;
	@Column(name = "postTitle")
	private String title;
	@Column(name = "postDescription")
	private String description;
	@Column(name = "postTime")
	private Date time;
	@Column(name = "userId")
	private int userId;
	
	
	
	
	
	
	public Posts() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Posts(int pid, String title, String description, Date time, int userId) {
		super();
		this.pid = pid;
		this.title = title;
		this.description = description;
		this.time = time;
		this.userId = userId;
	}
	
	
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Posts [pid=" + pid + ", title=" + title + ", description=" + description + ", time=" + time + ", userId="
				+ userId + "]";
	}
	
	
	
}

package com.brandon.bugtracker.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String project_name;
	
	@Column(nullable = false, length = 100)
	private String description;
	
	@Column(nullable = false, length = 20)
	private String submission_date;
	
	@Column(nullable = false, length = 20)
	private String duration;
	
	@Column(nullable = false, length = 20)
	private String client_name;
	
	@Column(nullable = false, length = 20)
	private String client_address;
	
	@Column(nullable = false, length = 20)
	private String phone_no;
	
	@Column(nullable = false, length = 45)
	private String emailId;
	
	@Column(nullable = false, length = 20)
	private String department_name;
	
	@Column(nullable = false, length = 45)
	private String project_lead;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProject_name() {
		return project_name;
	}
	
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSubmission_date() {
		return submission_date;
	}
	
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getClient_name() {
		return client_name;
	}
	
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	public String getClient_address() {
		return client_address;
	}
	
	public void setClient_address(String client_address) {
		this.client_address = client_address;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getDepartment_name() {
		return department_name;
	}
	
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	public String getProject_lead() {
		return project_lead;
	}
	
	public void setProject_lead(String project_lead) {
		this.project_lead = project_lead;
	}
	
	
	
	

}

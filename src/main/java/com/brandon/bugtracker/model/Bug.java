package com.brandon.bugtracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bugs")
public class Bug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bugId;
	
	@Column(nullable = false, length = 20)
	private String bugName;
	
	@Column(nullable = false, length = 20)
	private String bugType;

	@Column(nullable = false, length = 20)
	private String bugLevel;
	
	@Column(nullable = false, length = 20)
	private int priority;
	
	@Column(nullable = false, length = 20)
	private String projectName;
	
	@Column(nullable = false, length = 20)
	private String testerCode;
	
	@Column(nullable = false, length = 20)
	private String bugDate;
	
	@Column(nullable = false, length = 20)
	private String employeeCode;
	
	@Column(nullable = false, length = 20)
	private String status;
	
	
	public Long getBugId() {
		return bugId;
	}
	
	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}
	
	public String getBugName() {
		return bugName;
	}
	
	public void setBugName(String bugName) {
		this.bugName = bugName;
	}
	
	public String getBugLevel() {
		return bugLevel;
	}
	
	public void setBugLevel(String bugLevel) {
		this.bugLevel = bugLevel;
	}
	
	public String getBugType() {
		return bugType;
	}

	public void setBugType(String bugType) {
		this.bugType = bugType;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getTesterCode() {
		return testerCode;
	}
	
	public void setTesterCode(String testerCode) {
		this.testerCode = testerCode;
	}
	
	public String getBugDate() {
		return bugDate;
	}
	
	public void setBugDate(String bugDate) {
		this.bugDate = bugDate;
	}
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

package com.pack.SpringBootBloodBank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donar")
public class Donars {
	
	public Donars(long id, long patientId, String name, String bloodGroup, String time, long level, String notes,
			String status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.time = time;
		this.level = level;
		this.notes = notes;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long patientId;
	private String name;
	private String bloodGroup;
	private String time;
	private long level;
	private String notes;
	
	@Column(columnDefinition="varchar(255) default 'pending'")
	private String status;
	
	public Donars() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Donars [id=" + id + ", patientId=" + patientId + ", name=" + name + ", bloodGroup=" + bloodGroup
				+ ", time=" + time + ", level=" + level + ", notes=" + notes + ", status=" + status + "]";
	}

	
	
}
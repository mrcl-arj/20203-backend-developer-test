package com.marcelo.ZSSN.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "survivor")
public class Survivor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private String name;
	
	//@Enumerated(EnumType.STRING)
	private String gender;
	
	private LocalDate dateOfBirth;
	
	@Column(columnDefinition = "boolean default false")
	private boolean zombie;
	
	@Column(columnDefinition = "int default 0")
	private int infected;

	private float latitude;
	
	private float longitude;

	@OneToMany(mappedBy = "survivor", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Item> inventory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public boolean isZombie() {
		return zombie;
	}

	public void setZombie(boolean zombie) {
		this.zombie = zombie;
	}
	
	public int getInfected() {
		return infected;
	}

	public void setInfected(int infected) {
		this.infected = infected;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

}

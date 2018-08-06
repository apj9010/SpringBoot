package com.cg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

private String text;
@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
private Sender name;
public Sender getName() {
	return name;
}

public void setName(Sender name) {
	this.name = name;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}
}

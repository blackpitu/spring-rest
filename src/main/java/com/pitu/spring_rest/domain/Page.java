package com.pitu.spring_rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Page {
	private String id;
	private String about;
	public String getId() {
		return id;
	}
	public String getAbout() {
		return about;
	}
	@Override
	public String toString() {
		return "Page [id=" + id + ", about=" + about + "]";
	}
	
	
}

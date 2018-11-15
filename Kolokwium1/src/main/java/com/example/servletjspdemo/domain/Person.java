package com.example.servletjspdemo.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class Person {
	
	private String firstName = "unknown";
	private Date dataStart;
	private Date dataStop;
	
	public Person(String firstName, String dataStart, String firstStop) {
		super();
	}
	
	public Person(String firstName, Date dataStart, Date dataStop) {
		super();
		this.firstName = firstName;
		this.dataStart = dataStart;
		this.dataStop = dataStop;
	}

	public String getFirstName() {

		return firstName;
	}
	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public Date getDataStop() {
		return dataStop;
	}

	public void setDataStop(Date dataStop) {
		this.dataStop = dataStop;
	}
}

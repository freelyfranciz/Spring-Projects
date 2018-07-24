package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Instructor_detail")
public class InstructorDetail {
	
	//annotate the class as entity and map to db table
	
	//define the fields
	
	//annotate the fields with db column names
	
	//create constructors
	
	//generate setters and getters methods
	
	//generate toString() method
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String yotubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String yotubeChannel, String hobby) {
		this.yotubeChannel = yotubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYotubeChannel() {
		return yotubeChannel;
	}

	public void setYotubeChannel(String yotubeChannel) {
		this.yotubeChannel = yotubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", yotubeChannel=" + yotubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
}
